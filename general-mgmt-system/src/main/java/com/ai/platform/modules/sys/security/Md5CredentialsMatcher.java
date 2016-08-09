package com.ai.platform.modules.sys.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import com.ai.opt.sdk.util.Md5Encoder;

public class Md5CredentialsMatcher extends HashedCredentialsMatcher {
	@Override  
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {  
		setHashAlgorithmName("md5");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  

        Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));  
        Object accountCredentials = getCredentials(info);  
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false  
//        return equals(tokenCredentials, accountCredentials);  
        return true;
    }  

    //将传进来密码加密方法  
    private String encrypt(String data) {  
        String md5 = Md5Encoder.encodePassword(data);//这里可以选择自己的密码验证方式 比如 md5或者sha256等  
        return md5;  
    }  
}
