<%@page import="com.ai.opt.sdk.components.ccs.CCSClientFactory"%>
<%@page import="com.ai.opt.uac.web.constants.Constants"%>
<%@page import="com.ai.opt.sdk.components.mcs.MCSClientFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String _base = request.getContextPath();
    request.setAttribute("_base", _base);
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma", "No-cache");
    
    String _baasBase=_base+"/theme/changhong";
    request.setAttribute("_baasBase", _baasBase);
%>
<%
String default_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.DEFAULT_INDEX_URL_KEY);
request.setAttribute("default_index_url",default_index_url );
/* String citic_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_INDEX_URL_KEY);
request.setAttribute("citic_index_url",citic_index_url );
//System.out.println("[baas_pt_index_url]="+baas_pt_index_url);
String citic_yun_mall_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_YUN_MALL_INDEX_URL_KEY);
request.setAttribute("citic_yun_mall_index_url",citic_yun_mall_index_url );
String citic_help_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_HELP_INDEX_URL_KEY);
request.setAttribute("citic_help_index_url",citic_help_index_url ); */
%>
<script>
    var _base = "${_base}";
</script>
<script src="${_base}/resources/spm_modules/jquery/1.9.1/jquery.js"></script>
<script src="${_base}/resources/spm_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="${_base}/resources/spm_modules/seajs/2.3.0/dist/sea.js"></script>
<script src="${_base}/resources/spm_modules/seajs/seajs-css.js"></script>
<script src="${_base}/resources/spm_modules/app/core/config.js"></script>

<!-- UED style begin -->
<link rel="stylesheet" type="text/css" href="${_base}/theme/changhong/css/bootstrap/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${_base}/theme/changhong/css/bootstrap/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="${_base}/theme/changhong/css/modular/frame.css"/>
<link rel="stylesheet" type="text/css" href="${_base}/theme/changhong/css/modular/global.css"/>
<link rel="stylesheet" type="text/css" href="${_base}/theme/changhong/css/modular/login-regsiter.css"/>
<!-- UED style end -->


<!-- opt-uac -->
<%-- <link href="${_base}/theme/baas/css/opt-uac.css" rel="stylesheet" type="text/css"> --%>
