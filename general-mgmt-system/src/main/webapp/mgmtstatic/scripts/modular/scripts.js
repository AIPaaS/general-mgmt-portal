$(function($){
	setTimeout(function(){
		$('#content-wrapper > .row').css({opacity:1});
	},200);
	$('#sidebar-nav .dropdown-toggle').on('click',function(e){
		e.preventDefault();var $item=$(this).parent();
		if(!$item.hasClass('open')){
			$item.parent().find('.open .submenu').slideUp('fast');
			$item.parent().find('.open').toggleClass('open');
		}
$item.toggleClass('open');
if($item.hasClass('open')){
	$item.children('.submenu').slideDown('fast');
}else{
	$item.children('.submenu').slideUp('fast');}});
	$('body').on('mouseenter','#page-wrapper.nav-small #sidebar-nav .dropdown-toggle',
	function(e){var $sidebar=$(this).parents('#sidebar-nav');
	if($(document).width()>=992){
		var $item=$(this).parent();
		$item.addClass('open');
		$item.children('.submenu').slideDown('fast');}});
		$('body').on('mouseleave','#page-wrapper.nav-small #sidebar-nav > .nav-pills > li',
		function(e){
			var $sidebar=$(this).parents('#sidebar-nav');
			if($(document).width()>=992){var $item=$(this);
				if($item.hasClass('open')){
					$item.find('.open .submenu').slideUp('fast');
					$item.find('.open').removeClass('open');
					$item.children('.submenu').slideUp('fast');
				}
$item.removeClass('open');}});
$('#make-small-nav').click(function(e){
	$('#page-wrapper').toggleClass('nav-small');});
	$(window).smartresize(function(){
		if($(document).width()<=991){
			$('#page-wrapper').removeClass('nav-small');}});
			$('.mobile-search').click(function(e){
				e.preventDefault();
				$('.mobile-search').addClass('active');
				$('.mobile-search form input.form-control').focus();
			});
			$(document).mouseup(function(e){
				var container=$('.mobile-search');
				if(!container.is(e.target)&&container.has(e.target).length===0)
				{container.removeClass('active');
				}});
				$('.fixed-leftmenu #col-left').nanoScroller({alwaysVisible:true,iOSNativeScrolling:false,preventPageScrolling:true,contentClass:'col-left-nano-content'});
				$("[data-toggle='tooltip']").each(function(index,el){
					$(el).tooltip({placement:$(this).data("placement")||'top'});
				});
		});
		$.fn.removeClassPrefix=function(prefix){
			this.each(function(i,el){
				var classes=el.className.split(" ").filter(function(c){
					return c.lastIndexOf(prefix,0)!==0;});
					el.className=classes.join(" ");});
					return this;};(function($,sr){
						var debounce=function(func,threshold,execAsap){
							var timeout;return function debounced(){
								var obj=this,args=arguments;
								function delayed(){if(!execAsap)
					func.apply(obj,args);
					timeout=null;};
					if(timeout)
					clearTimeout(timeout);
					else if(execAsap)
					func.apply(obj,args);
					timeout=setTimeout(delayed,threshold||100);
							};
						}
					jQuery.fn[sr]=function(fn){
						return fn?this.bind('resize',debounce(fn)):this.trigger(sr);
					};
					})
					(jQuery,'smartresize');
					


/*配置中心
	var oShowconf=document.getElementById('showconf');
	var oHidconf=document.getElementById('hidconf');
	var oColor=document.getElementById('acolor');
	oShowconf.onmouseover=function(){
		if(oHidconf.style.display=='block'){
			oHidconf.style.display='none';
		}else{
			oHidconf.style.display='block';
		}
		oShowconf.style.height='50px';
		oShowconf.style.background='#fff';
		oColor.style.color='#000';
	}
	 oShowconf.onmouseout=function(){
	 	if(oHidconf.style.display=='none'){
			oHidconf.style.display='block';
		}else{
			oHidconf.style.display='none';
		}
		oShowconf.style.background='none';
		oColor.style.color='#fff';
	 }*/
	 
	 
//公告滚动
	var timer;
	var elem = document.getElementById('elem');
	var elem1 = document.getElementById('elem1');
	var elem2 = document.getElementById('elem2');
	elem2.innerHTML = elem1.innerHTML;
	timer = setInterval(Scroll,40);
	function Scroll(){
		if(elem.scrollTop>=elem1.offsetHeight){
			elem.scrollTop -= elem1.offsetHeight;
		}else{
			elem.scrollTop += 1;
		}
	}	
	elem.onmouseover = function(){
		clearInterval(timer);
	}	
	elem.onmouseout = function(){
		timer = setInterval(Scroll,40);
	};
 
//转换rem值
    		function justifyRem(){
			document.documentElement.style.fontSize = document.documentElement.clientWidth/16 + 'px';
		}
		justifyRem();
		window.addEventListener('resize',justifyRem,false);