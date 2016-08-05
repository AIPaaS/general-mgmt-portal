package com.ai.opt.sso.handler;

import java.security.GeneralSecurityException;
import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;
import javax.validation.constraints.NotNull;

import org.jasig.cas.Message;
import org.jasig.cas.authentication.BasicCredentialMetaData;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.handler.NoOpPrincipalNameTransformer;
import org.jasig.cas.authentication.handler.PasswordEncoder;
import org.jasig.cas.authentication.handler.PlainTextPasswordEncoder;
import org.jasig.cas.authentication.handler.PrincipalNameTransformer;
import org.jasig.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.cas.authentication.support.PasswordPolicyConfiguration;
import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.data.api.user.param.UserLoginResponse;
import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.util.Md5Encoder;
import com.ai.opt.sso.exception.AccountNameNotExistException;
import com.ai.opt.sso.exception.CaptchaErrorException;
import com.ai.opt.sso.exception.CaptchaIsNullException;
import com.ai.opt.sso.exception.CaptchaOutTimeException;
import com.ai.opt.sso.exception.EmailNotExistException;
import com.ai.opt.sso.exception.PasswordErrorException;
import com.ai.opt.sso.exception.PasswordIsNullException;
import com.ai.opt.sso.exception.PhoneNotExistException;
import com.ai.opt.sso.exception.SystemErrorException;
import com.ai.opt.sso.exception.UsernameIsNullException;
import com.ai.opt.sso.principal.BssCredentials;
import com.ai.opt.sso.service.LoadAccountService;
import com.ai.opt.sso.util.RegexUtils;
import com.ai.opt.uac.web.constants.Constants.Register;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.StringUtil;

public final class BssCredentialsAuthencationHandler extends AbstractPreAndPostProcessingAuthenticationHandler{

	@Resource
	private LoadAccountService loadAccountService;
	@NotNull
	private PasswordEncoder passwordEncoder;

	@NotNull
	private PrincipalNameTransformer principalNameTransformer;
	private PasswordPolicyConfiguration passwordPolicyConfiguration;
	
	public LoadAccountService getLoadAccountService() {
		return loadAccountService;
	}
	public void setLoadAccountService(LoadAccountService loadAccountService) {
		this.loadAccountService = loadAccountService;
	}
	public BssCredentialsAuthencationHandler(){
		this.passwordEncoder = new PlainTextPasswordEncoder();
		this.principalNameTransformer = new NoOpPrincipalNameTransformer();
	}
	@Override
	public boolean supports(Credential credentials) {
		return credentials!=null&&(BssCredentials.class.isAssignableFrom(credentials.getClass()));
	}

	@Override
	protected HandlerResult doAuthentication(final Credential credentials)
			throws GeneralSecurityException, PreventedException {
		logger.debug("开始认证用户凭证credentials");
		if(credentials == null){
			logger.info("用户凭证credentials为空");
			throw new LoginException("Credentials is null");
		}
		BssCredentials bssCredentials = (BssCredentials) credentials;
		final String username = bssCredentials.getUsername();
		final String pwdFromPage = bssCredentials.getPassword();
		final String captchaCode = bssCredentials.getCaptchaCode().toLowerCase();
	    final String sessionId = bssCredentials.getSessionId();
		//用户名非空校验
		if(!StringUtils.hasText(username)){
			logger.error("请输入手机号码或邮箱地址");
			throw new UsernameIsNullException();
		}
		//密码非空校验
		if(!StringUtils.hasText(pwdFromPage)){
			logger.error("密码为空！");
			throw new PasswordIsNullException();
		}
		
		
		 // 验证码非空校验
        if (!StringUtils.hasText(captchaCode)) {
            logger.error("请输入验证码");
            throw new CaptchaIsNullException();
        }

        ICacheClient iCacheClient = MCSClientFactory.getCacheClient(Register.CACHE_NAMESPACE);
        // 生成的校验码
        String cookieCaptcha = iCacheClient.get(Register.CACHE_KEY_VERIFY_PICTURE + sessionId)
                .toLowerCase();
        // 校验图片是否失效
        if (StringUtil.isBlank(cookieCaptcha)) {
            throw new CaptchaOutTimeException();
        }
        // 校验验证码
        if (!cookieCaptcha.equals(bssCredentials.getCaptchaCode().toLowerCase())) {
            throw new CaptchaErrorException();
        }
		
		
		UserLoginResponse user = null;
		try {
			
			user = loadAccountService.loadAccount(bssCredentials);
			if(user == null||StringUtil.isBlank(user.getUserId())){
				if(RegexUtils.checkIsPhone(bssCredentials.getUsername())){
					logger.error("手机号码未注册");
					throw new PhoneNotExistException();
				}
				else if(RegexUtils.checkIsEmail(bssCredentials.getUsername())){
					logger.error("邮箱未绑定");
					throw new EmailNotExistException();
				}
				else{
					logger.error("账号未注册");
					throw new AccountNameNotExistException();
				}
			}
			String dbPwd=user.getLoginPassword();
			logger.info("【dbPwd】="+dbPwd);
			logger.info("【pwdFromPage】="+pwdFromPage);
			String encryPwdFromPage=Md5Encoder.encodePassword(pwdFromPage);
			if(!encryPwdFromPage.equals(dbPwd)){
				//密码不对
				logger.error("密码错误！");
				throw new PasswordErrorException();
			}
			/*if(!SSOConstants.ACCOUNT_ACITVE_STATE.equals(user.getState())){
				//密码不对
				throw new CredentialException("账号状态异常");
			}
			Date currentDate=new Date();
			Date acitveDate=user.getActiveTime();
			Date inactiveDate=user.getInactiveTime();
			if(acitveDate!=null&&currentDate.before(acitveDate)){
				throw new CredentialException("账号未生效");
			}
			if(inactiveDate!=null&&inactiveDate.before(currentDate)){
				throw new CredentialException("账号已失效");
			}*/
			
			//BeanUtils.copyProperties(bssCredentials, user);
			bssCredentials.setUserId(user.getUserId());
			bssCredentials.setMobile(user.getMobile());
			bssCredentials.setEmail(user.getEmail());
			bssCredentials.setLoginName(user.getLoginName());
			
		}
		/*catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("从user拷贝属性到bssCredentials出错",e);
			throw new SystemErrorException();
		}*/
		catch (RPCSystemException e) {
			logger.error("调用查询账户服务（Dubbo）失败",e);
			throw new CredentialException("系统错误");
		}
		catch (Exception e) {
			logger.error("系统异常",e);
			throw new SystemErrorException();
		}
		logger.info("用户 [" + username + "] 认证成功。");
        return creatHandlerResult(bssCredentials, new SimplePrincipal(username),null);
	}

	private HandlerResult creatHandlerResult(BssCredentials bssCredentials,
			SimplePrincipal simplePrincipal, List<Message> warnings) {
		return new HandlerResult(this, new BasicCredentialMetaData(bssCredentials), simplePrincipal, warnings);
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public PrincipalNameTransformer getPrincipalNameTransformer() {
		return principalNameTransformer;
	}

	public void setPrincipalNameTransformer(
			PrincipalNameTransformer principalNameTransformer) {
		this.principalNameTransformer = principalNameTransformer;
	}

	public PasswordPolicyConfiguration getPasswordPolicyConfiguration() {
		return passwordPolicyConfiguration;
	}

	public void setPasswordPolicyConfiguration(
			PasswordPolicyConfiguration passwordPolicyConfiguration) {
		this.passwordPolicyConfiguration = passwordPolicyConfiguration;
	}

}
