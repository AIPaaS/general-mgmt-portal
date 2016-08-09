

$(function(){
$(".nav li").click(function () {
                $(".nav li").each(function () {
                    $(this).removeClass("current");
                });
                $(this).addClass("current");
            });
$('.nav li').click(function(){
 $(this).children('.current-cnt').show().end().siblings(this).children(".current-cnt").hide();
});
});


$(function(){ 
$(document).bind("click",function(e){ 
var target = $(e.target); 
if(target.closest(".nav li").length == 0){ 
$(".current-cnt").hide(); } 
});
});




$(function(){ 
$(document).bind("click",function(e){ 
var target = $(e.target); 
if(target.closest(".user-cnt p").length == 0){ 
$(".user-cnt p").css("background","none"); } 
});
});


$(function(){
$(".msg").click(function () {
   $(".msg-cnt").animate({right:'0'},200);
});
});


$(function(){
$(".p a").click(function () {
   $(".msg-cnt").animate({right:'-280px'},200);
});
});



  $(document).ready(function(){
	if ($.support.leadingWhitespace) {
		$(window).scroll(function(){
			var top = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
			if(top>139){
		   var divcss = {
                position: 'fixed',
                top: '10px',
  
              };
		   $(".help-introduce-post").css(divcss);
			}
		});
	}
});

 $(document).ready(function(){
	if ($.support.leadingWhitespace) {
		$(window).scroll(function(){
			var top = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
			if(top<138){
		   var divcss = {
                position: 'fixed',
                top: '139px',
              };
		   $(".help-introduce-post").css(divcss);
			}
		});
	}
});


