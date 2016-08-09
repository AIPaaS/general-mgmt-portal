<%@page import="com.ai.opt.uac.web.constants.Constants"%>
<%@page import="com.ai.opt.sdk.components.mcs.MCSClientFactory"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="subnav" >
   <div class="nav" >
     <ul>
	   <li id="baseInfo"><a href="${_base}/center/baseInfo/getAccountInfo">基本信息</a></li>
	   <li id="updatePassword"><a href="${_base}/center/password/confirminfo">修改密码</a></li>
	   <li id="updatePhone"><a href="${_base}/center/phone/confirminfo">修改手机号</a></li>
	   <li id="updateEmail"><a href="${_base}/center/email/confirminfo"></a></li>
  </ul>
  </div>
</div>
<script type="text/javascript">
		(function() {
			seajs.use([ 'app/inc/leftmenu' ], function(LeftMenu) {
				var pager = new LeftMenu({
					element : document.body
				});
				pager.render();
			});
		})(); 
  </script>