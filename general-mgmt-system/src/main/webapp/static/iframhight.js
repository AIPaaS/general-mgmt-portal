
var browserVersion = window.navigator.userAgent.toUpperCase();
var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
var isIE9More = (! -[1, ] == false);
// 计算页面的实际高度，iframe自适应会用到
function calcPageHeight(doc) {
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
	        
	    } catch (ex) { }
    return height;
}

window.onload = function() {
	
	var mgmtPath = document.URL.getParameter("mgmtPath");
	
	if(mgmtPath !=null && mgmtPath!="null"){
		setCookie("mgmtPath", mgmtPath, 60*60*24);	
	}
	
	if(mgmtPath== null|| mgmtPath=="null"){	
		
		mgmtPath=unescape(getcookie("mgmtPath"));		
	}
    var doc = document;
    var height = calcPageHeight(doc);
   
    var myifr = doc.getElementById('myifr');

    if (myifr) {
        myifr.src = mgmtPath+'/static/agentifram.jsp?height=' + height;
        // console.log(doc.documentElement.scrollHeight)     
    }
};