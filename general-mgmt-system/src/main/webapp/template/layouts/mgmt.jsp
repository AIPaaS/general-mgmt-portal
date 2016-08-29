<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/mgmtstatic/default"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title>运营管理平台<sitemesh:title/></title>
	<%@include file="/template/mgmt/head.jsp" %>		

	<sitemesh:head/>
</head>
<body>
<sitemesh:body/>

 
 <script src="${iotStatic}/scripts/modular/p-skin-changer.js"></script>  
<script src="${iotStatic}/scripts/plugin/jquery.nanoscroller.min.js"></script>
<script src="${iotStatic}/scripts/modular/skin.js"></script>  
<script src="${iotStatic}/scripts/modular/frame.js"></script>  
<script src="${iotStatic}/scripts/modular/eject.js"></script>  
<script src="${iotStatic}/scripts/modular/scripts.js"></script>


<!--日期-->
<script src="${iotStatic}/scripts/date/WdatePicker.js"></script>
<!--ztree-->
<script src="${iotStatic}/scripts/ztree/jquery-1.4.4.min.js"></script>  
<script src="${iotStatic}/scripts/ztree/jquery.ztree.core-3.2.min.js"></script>  
<script src="${iotStatic}/scripts/ztree/jquery.ztree.excheck-3.2.min.js"></script>  
<link href="${ctxStatic}/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css" rel="stylesheet" />
<script src="${ctxStatic}/jquery-jbox/2.3/jquery.jBox-2.3.min.js" type="text/javascript"></script>


	<script type="text/javascript" language="javascript">
    var browserVersion = window.navigator.userAgent.toUpperCase();
    var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
    var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
    var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
    var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
    var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
    var isIE9More = (! -[1, ] == false);
    function reinitIframe(iframeId, minHeight) {
        try {
            var iframe = document.getElementById(iframeId);
            var bHeight = 0;
            if (isChrome == false && isSafari == false)
                bHeight = iframe.contentWindow.document.body.scrollHeight;

            var dHeight = 0;
            if (isFireFox == true)
                dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
            else if (isIE == false && isOpera == false)
                dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
            else if (isIE == true && isIE9More) {//ie9+
                var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
                if (heightDeviation == 0) {
                    bHeight += 3;
                } else if (heightDeviation != 3) {
                    eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                    bHeight += 3;
                }
            }
            else//ie[6-8]、OPERA
                bHeight += 3;

            var height = Math.max(bHeight, dHeight);
            if (height < minHeight) height = minHeight;
            iframe.style.height = height + "px";
        } catch (ex) { }
    }
    function startInit(iframeId, minHeight) {
        eval("window.IE9MoreRealHeight" + iframeId + "=0");
        window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 200);
    }
    startInit('mainFrame', 1000);
</script>
</body>
</html>