// 计算页面的实际高度，iframe自适应会用到
function calcPageHeight(doc) {
    var cHeight = Math.max(doc.body.clientHeight, doc.documentElement.clientHeight);
    var sHeight = Math.max(doc.body.scrollHeight, doc.documentElement.scrollHeight);
    var height  = Math.max(cHeight, sHeight);
    return height;
}

window.onload = function() {
	var locURL=window.location.protocol+"//"+window.location.hostname+":"+window.location.port+"/"+window.location.pathname;

    var doc = document;
    var height = calcPageHeight(doc);
   
    var myifr = doc.getElementById('myifr');

    if (myifr) {
        myifr.src = unescape(getcookie("mgmtPath"))+'/static/agentifram.jsp?height=' + height;
        // console.log(doc.documentElement.scrollHeight)     
    }
};