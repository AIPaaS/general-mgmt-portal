<%@ page contentType="text/html; charset=UTF-8"%>
<html>  
    <head>  
        <title>正在登录....</title>  
    </head>  
    <body>  
        <script type="text/javascript">  
            <%  
                Boolean isFrame = (Boolean)request.getAttribute("isFrame");  
                Boolean isLogin = (Boolean)request.getAttribute("isLogin");  
                String serviceUrl=(String)request.getAttribute("serviceUrl");
                String ticket=(String)request.getAttribute("ticket");
                String redircetUrl="";
                if(!serviceUrl.contains("?")){
                	redircetUrl=serviceUrl+"?ticket="+ticket;                	
                }
                else{
                	redircetUrl=serviceUrl+"&ticket="+ticket; 
                }
                System.out.println("opt-sso isFrame="+isFrame);
                System.out.println("opt-sso isLogin="+isLogin);
                System.out.println("opt-sso serviceUrl="+serviceUrl);
                System.out.println("opt-sso ticket="+ticket);
                System.out.println("opt-sso redircetUrl="+redircetUrl);
                // 登录成功  
                if(isLogin){  
                    if(isFrame){%>  
                        parent.location.replace('<%=redircetUrl%>');  
                    <%} else{%>  
                        location.replace('<%=redircetUrl%>');  
                    <%}  
                }  
            %>  
            // 回调  
            ${callback}({'login':${isLogin ? '"success"': '"fails"'}, 'msg': ${isLogin ? '""': '"用户名或密码错误！"'}})  
        </script>  
    </body>  
</html>  
