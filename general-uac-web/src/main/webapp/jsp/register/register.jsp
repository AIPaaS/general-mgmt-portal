<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@ include file="/inc/inc.jsp"%>
<!--Support IE Text -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
<title>注册</title>
<script type="text/javascript" src="${_base}/theme/baas/js/jquery.toggle-password.js" ></script> 

<script type="text/javascript">
 (function () {
	seajs.use('app/register/register', function (RegisterPager) {
		var pager = new RegisterPager();
		pager.render();
	});
})(); 

 $(function(){
	$('#password').togglePassword({
		el: '#togglePassword'
	});
}); 
//判断输入密码的类型  
function CharMode(iN){  
if (iN>=48 && iN <=57) //数字  
return 1;  
if (iN>=65 && iN <=90) //大写  
return 2;  
if (iN>=97 && iN <=122) //小写  
return 4;  
else  
return 8;   
}  
//bitTotal函数  
//计算密码模式  
function bitTotal(num){  
modes=0;  
for (i=0;i<4;i++){  
if (num & 1) modes++;  
num>>>=1;  
}  
return modes;  
}  
//返回强度级别  
function checkStrong(sPW){  
if (sPW.length<=8)  
return 0; //密码太短  
Modes=0;  
for (i=0;i<sPW.length;i++){  
//密码模式  
Modes|=CharMode(sPW.charCodeAt(i));  
}  
return bitTotal(Modes);  
}  
 
//显示颜色  
function pwStrength(pwd){  
O_color="#eeeeee";  
L_color="#FF0000";  
M_color="#FF9900";  
H_color="#33CC00";  
if (pwd==null||pwd==''){  
Lcolor=Mcolor=Hcolor=O_color;  
}  
else{  
S_level=checkStrong(pwd);  
switch(S_level) {  
case 0:  
Lcolor=Mcolor=Hcolor=O_color;  
case 1:  
Lcolor=L_color;  
Mcolor=Hcolor=O_color;  
break;  
case 2:  
Lcolor=Mcolor=M_color;  
Hcolor=O_color;  
break;  
default:  
Lcolor=Mcolor=Hcolor=H_color;  
}  
}  
document.getElementById("strength_L").style.background=Lcolor;  
document.getElementById("strength_M").style.background=Mcolor;  
document.getElementById("strength_H").style.background=Hcolor;  
return;  
}  
$(document).ready(function(){
	$(".fuwu-clo").click(function(){
	  $(".pop-fuwu").hide(200);
	});
	});
</script>
</head>

<body>
<div class="pop-fuwu" style="display:none;">
  <div class="fuwu-bg"></div>
  <div class="fuwu-cnt">
  <div class="fuwu-close"><img src="${_base}/theme/baas/images/close.png"></div>
   <div class="fwcnt-title">
    <p>运营家·Billing 服务条款</p>
    <span>(修订时间：2016-04-07)</span>
   </div>
   <div class="tkcnt">
    <h3>1. 合约定义</h3>
    <p>1. 本合约是运营家•Billing 用户（包括使用的个人和其代表的企业）与运营家•Billing云计费运营企业亚信科技（中国）有限公司之间的法律契约，用户注册运营家•Billing服务即代表接受本条款的约束，并自注册成功之时即成为本合约一方、受该使用条款约束。</p>
    <p>2. 下文中的“运营家•Billing”指亚信云计费平台“运营家•Billing”或其运营企业亚信科技（中国）有限公司。</p>
    <h3>2. 合法使用</h3>
    <p>1. 运营家•Billing服务仅限于提供给用户用作正常和合法的业务。</p>
    <p>1）用户不得利用运营家•Billing服务制作、上传、发布、传播如下法律、法规和政策禁止的内容：</p>
    <p>•反对宪法所确定的基本原则的；</p>
    <p>•危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；</p>
    <p>•损害国家荣誉和利益的；</p>
    <p>•煽动民族仇恨、民族歧视，破坏民族团结的；</p>
    <p>•破坏国家宗教政策，宣扬邪教和封建迷信的；</p>
    <p>•散布谣言，扰乱社会秩序，破坏社会稳定的；</p>
    <p>•散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；</p>
    <p>•侮辱或者诽谤他人，侵害他人合法权益的；</p>
    <p>•含有法律、法规和政策禁止的其他内容的信息；</p>
    <p>2）用户不得利用运营家•Billing服务进行如下行为：</p>
    <p>•	含有任何性或性暗示或其他低俗类信息的；</p>
    <p>•	发送骚扰、垃圾广告或信息的；</p>
    <p>•	涉及他人隐私、个人信息或资料的；</p>
    <p>•	侵害他人名誉权、肖像权、知识产权、商业秘密等合法权利的；</p>
    <p>•	含有其他干扰运营家•Billing正常运营和侵犯其他用户或其他第三方合法权益内容的信息；</p>
    <p>•	利用运营家•Billing账户从事任何违法犯罪活动的；</p>
    <p>•	对运营家•Billing产品进行了任何形式的对其他第三方的再授权使用、销售或转让；</p>
    <p>•	为设计开发竞争产品对运营家•Billing产品进行任何形式的反向工程，或抄袭模仿运营家•Billing的设计；</p>
    <p>•	其他违反法律法规规定、侵犯其他用户合法权益、干扰运营家•Billing产品正常运营或运营家•Billing公司未明示授权的行为；</p>
    <p>3）如果用户使用运营家•Billing产品从事上述1.1条及1.2条的行为，运营家•Billing有权随时停止服务、并要求用户赔偿由此造成的损失。</p>
    <p>2. 运营家•Billing使用用户所拥有的电子邮件地址、手机号码等作为用户权证的唯一识别信息。当免费试用期过后，未付费的用户将不再享有运营家•Billing的服务，运营家•Billing有权随时删除该用户的所有用户数据。</p>
    <h3>3. 数据归属权</h3>
    <p>1. 用户在运营家•Billing平台创建的独创性数据归属用户所有，用户有权对其所创建的数据进行任何形式的处置，包括从平台中复制、导出和删除。</p>
    <p>2. 运营家•Billing的源代码、LOGO、界面设计、开发文档、应用程序编程接口（API）所关联的所有知识产权均归属亚信科技（中国）有限公司。</p>
    <p>3. 依照明确的服务约定，运营家•Billing在用户未继续付费且未继续使用达到6个月后，运营家•Billing有权将用户数据从平台上删除，而无需向用户承担任何赔偿责任。该数据包括但不限于用户账户信息、用户使用过程中创建的独创性使用数据。删除的数据将无法从平台上导出或恢复。</p>
    <h3>4. 用户数据安全性</h3>
    <p>1. 运营家•Billing应当从组织结构和技术角度尽最大努力保护用户数据安全，只根据用户在网站上或APP移动端的行为指示来分发用户的信息。未经用户同意，运营家•Billing不会将用户产生的具体数据提供任何无关第三方，但法律法规另有规定的除外。</p>
    <p>2. 运营家•Billing保留使用汇总统计性信息的权利，这些信息应当是匿名，且不是针对特定用户的。</p>
    <p>3. 用户如果需要运营家•Billing全面删除其在运营家•Billing上创建的用户数据，需要书面向运营家•Billing提出申请，并在申请书中加盖公司公章。</p>
    <h3>5. 服务连续性</h3>
    <p>1. 运营家•Billing将尽最大努力保障软件平台的连续可靠运行。对于付费用户，运营家•Billing承诺98%以上的正常在线率，对于未付费用户，运营家•Billing不提供任何保证或承担任何形式的赔偿责任。</p>
    <p>2. 运营家•Billing将尽最大努力保障用户数据的安全备份。对于付费用户，运营家•Billing承诺在有任何用户数据因服务器存储设备损坏时以最快的速度从最近的备份中恢复数据，但无法承诺100%的数据恢复，对因数据丢失带来的其他连带或间接损失不承担任何责任；对于未付费用户，运营家•Billing不提供恢复服务。</p>
    <p>3. 在发生需要从备份文件中恢复数据的情形时，运营家•Billing通常需要4至48小时完成，在此时间范围内的数据恢复视作服务是连续的。</p>
    <p>4. 因重大自然灾害、战争等其他不可抗力导致的运营家•Billing服务中断和长时间终止，运营家•Billing不承担赔偿责任。</p>
    <h3>6. 条款变更</h3>
    <p>1. 运营家•Billing有权随时对本合约的条款进行修订，并在修订后更新在运营家•Billing网站上。若用户继续使用运营家•Billing服务，则意味着同意并自愿遵守修改后的使用条款。</p>
    <p>2. 修订的条款始终在运营家•Billing官方网站公示。</p>
    <h3>7. 其他条款</h3>
    <p>本合约条款无论因何种原因部分无效或不可执行，其余条款仍有效，对双方具有约束力。本合约的成立、生效、履行、解释及纠纷解决，都适用于中华人民共和国的法律。本合约的签订地为北京。</p>
    <p>如果就本协议的解释或执行发生争议，双方应首先力争通过友好协商解决该争议。如果在一方向其他方送达要求开始协商的书面通知后六十天内未能通过协商解决争议，那么任何一方均可将争议提交至北京仲裁委员会，按照其届时有效的规则进行仲裁。仲裁裁决是终局的，对各方均有约束力，不可上诉。仲裁费用由败诉方承担，除非仲裁裁决另有规定。当任何争议发生时以及在对任何争议进行仲裁时，除争议事项外，各方应继续行使各自在本协议项下的其他权利，履行各自在本协议项下的其他义务。</p>
   </div>
   <div class="fuwu-btn"><a href="#" class="fuwu-clo">同意并继续</a></div>
  </div>
 </div>
<!--服务条款弹出框结束-->
<%@ include file="/inc/head-rgister.jsp"%>

   <div class="regsiter-wrapper" id="register-form">
     <div class="regsiter-box">
        <div class="regsiter-wrapper-cnt">
	         <ul>
		         <li class="regsiter-title">账户注册</li>
		         <li class="user">
		         	<input type="text" name="phone" id="phone"class="int-xxlarge-user" placeholder="手机号码">
		         	<p class="regsiter-po">
			         	<span class="regsiter-note" id="errorPhoneMsg" style="display: none;">
			         		<span id="showPhoneMsg" ></span>
			         	</span>
		         	</p>
		         </li>
		         
		         <li class="password">
		         	<input type="password" name="password" id="password"class="int-xxlarge" placeholder="密码"><!-- onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value) -->
		         	<i class="icon-eye-open" id="togglePassword"></i>
		         	<p class="regsiter-po">
		         	<span class="regsiter-note" id="errorPawMsg" style="display: none;">
		         		<span id="showPawMsg"></span>
		         	</span>
		         	</p>
		         	<p>
		         		<label id="errorShowPM" style="display: none;">6~14个字符，数字、字母、符号组合，不包含空格</label>
		         	</p>
		         	<div class="regsiter-set-password" style="display:none">
				          <p class="low" id="strength_L">
					          <span class="f00" id=""></span>
					          <span>低</span>
				          </p>
				           <p class="in" id="strength_M">
					          <span class="eb6100"></span>
					          <span>中</span>
				          </p>
				          <p class="gao" id="strength_H">
					          <span class="green"></span>
					          <span>高</span>
				          </p>
	          			</div>	
		         </li>
		         	
		         <li class="identifying">
		         	<input type="text" class="int-xlarge-identifying" style="width:176px;" placeholder="图形验证码" id="pictureVitenfy">
		         	<span ><A ><img src="${_base}/reg/getImageVerifyCode" id="randomImg"></A></span>
		         	<span ><a id="refresh">看不清?换一个</a></span>
		         	<p class="regsiter-po">
			         	<span class="regsiter-note" id="errorPicMsg" style="display: none;">
			         		<span id="showPicMsg" ></span>
			         	</span>
		         	</p>
		         </li>
		         <li class="SMSidentifying">
		         	<input type="text" class="int-xlarge-SMSidentifying" placeholder="短信验证码" id="phoneVerifyCode">
		         	 <span class="yzm">
		         	 	<input class="button"id="PHONE_IDENTIFY"  type="button" value="获取验证码" >
		         	 </span>
		         	<p class="regsiter-po">	
		         	<span class="regsiter-note" id="errorSmsMsg" style="display: none;">
		         		<span id="showSmsMsg"></span>
		         	</span>
		         	</p>
		         </li>
		         <li>
		         	<input type="button" class="regsiter-btn" value="注 册"  id="BTN_REGISTER">
		         	<input type="hidden" id="errorPhoneFlag">
		         	<input type="hidden" id="errorPicFlag">
		         	<input type="hidden" id="errorPassFlag">
		         	<input type="hidden" id="errorSMSFlag">
		         </li>
		         <li class="zuns">* 注册表示您同意遵守<A href="javascript:void(0)" class="fuwu">《运营家·Billing服务条款》</A></li>
	
	         </ul>
	         </div>
   		</div>
    </div>
    <%@ include file="/inc/foot.jsp"%>
   
</body>
</html>
