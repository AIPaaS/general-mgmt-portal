<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <div class="login-header"><!--登录头部-->
     <div class="login-header-cnt">
       <img id="img_logincheck" style="display:none;" src="${baas_pt_index_url }/logincheck?req=<%=new Date().getTime() %>">
       <div class="login-header-cnt-logo"><a href="${baas_pt_index_url }"><img src="${_base}/theme/baas/images/about.png"></a></div>
       <div class="login-header-cnt-mail">注册成功</div>
       </div>
</div>