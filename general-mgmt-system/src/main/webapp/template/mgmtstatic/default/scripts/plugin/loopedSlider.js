/*
 * 	loopedSlider - jQuery plugin
 *	written by Nathan Searles	
 *	http://code.google.com/p/loopedslider/
 *
 *	Copyright (c) 2009 Nathan Searles (http://nathansearles.com/loopedslider/)
 *	Dual licensed under the MIT (MIT-LICENSE.txt)
 *	and GPL (GPL-LICENSE.txt) licenses.
 *
 *	Built for jQuery library
 *	http://jquery.com
 *
 */
(function($){
 	$.fn.extend({ 
 		loopedSlider: function(options) {
    		return this.each(function() {

				// set defaults
				var defaults = {
					container : 'container',
					slideClass : 'slide',
					pagination : 'pagination',
					navButtons : 'nav-buttons', 
					fadeSpeed : 400,
					slideSpeed : 250,
					animateSpeed : 200,
					autoHeight : true,
					padding : 20,
					easing : 'easeOutQuad'
				};

				// set variables	
				var obj = $(this);
				var o = $.extend(defaults, options);
				var u = false;
				var w = obj.width(); 
				var h = obj.height();
				var f = $('.'+o.container, obj).find('div:first').attr('id');
				var l = $('.'+o.container, obj).find('div:last').attr('id');
				
				// funcitons
				function setToActive(c) {
					var current = $(c).attr('id');
					$('a[href$="'+current+'"]', obj).addClass('active');
				}
				
				// applies style to divs
				$('.'+o.container, obj).find('div').css({ 'z-index': 0, opacity: 0 });
				
				// load first slide
				$('.'+o.container, obj).find('div:eq(0)').animate({ opacity: 1.0 }, o.fadeSpeed, function() {						
					$(this).css({ 'z-index': 100 });				
					$(this).addClass('current');
					if (o.autoHeight===true) {
						// gets height of new slide
						var newHeight = $(this, obj).height() + o.padding;
						$('.'+o.container, obj).animate({'height': newHeight}, o.animateSpeed, o.easing);
					}
					setToActive(this);
				});		

				// fade code
				$('.'+o.pagination, obj).find('a').click(function(){
					if(u===false  && ($(this).hasClass('active')===false)) {
						u = true;
						// removes active
						$('a', obj).removeClass('active');

						// fades out current slide
						$('.'+o.container, obj).find('div').animate({ opacity: 0 }, o.fadeSpeed, function() {					
							$(this).removeClass('current');
							$(this).css({ 'z-index': 0 });				
						});

						// setsup value for new slide
						var x = 0;
						var parentId = $(this).attr('href');
						var parentSplit = parentId.split('-');
						x = ((parentSplit[1]*1));
						
						if (o.autoHeight===true) {
							// gets height of new slide
							var newHeight = $('#'+o.slideClass+'-'+(x), obj).height() + o.padding;
							$('.'+o.container, obj).animate({'height': newHeight}, o.animateSpeed, o.easing);
						}
						
						// fades in new slide
						$('#'+o.slideClass+'-'+(x), obj).animate({ opacity: 1.0 }, o.fadeSpeed, function() {
							$(this).css({ 'z-index': 100 });
							$(this).addClass('current');
							u = false;
							setToActive(this);		
						});
					}
					return false;
				});

				// slide code
				$('.'+o.navButtons, obj).find('a').click(function(){
					if(u===false) {
						u = true;
						var loop = false;
						var fLoop = f;
						var lLoop = l;

						// removes active state
						$('a', obj).removeClass('active');

						// flips directions
						if ($(this).hasClass('next')) {
							var nextD = -w;
							var previousD = w;
							var direction = +1;
						}
						if ($(this).hasClass('previous')) {
							nextD = w;
							previousD = -w;
							direction = -1;
						}

						// setup the loop
						if ($('#'+fLoop, obj).hasClass('current')) {
							loop = 'first';
						}
						if (($('#'+lLoop, obj).hasClass('current'))) {
							loop = 'last';
						}

						// get the name of the new slide
						if ((loop==='first') && ($(this).hasClass('previous'))) {
							lLoop = lLoop.split('-');
							x = ((lLoop[1]*1));
						} else if ((loop==='last') && ($(this).hasClass('next'))) {
							fLoop = fLoop.split('-');
							x = ((fLoop[1]*1));
						} else {
							// setsup value for new slide
							var getCurrent = $('.'+o.container, obj).find('.current').attr('id');
							getCurrent = getCurrent.split('-');
							x = ((getCurrent[1]*1+direction));
						}

						// gets height of new slide
						if (o.autoHeight===true) {
							var newHeight = $('#'+o.slideClass+'-'+(x), obj).height() + o.padding;
							$('.'+o.container, obj).animate({'height': newHeight}, o.animateSpeed, o.easing);
						}
						
						// sets next slide to slide in position		
						$('#'+o.slideClass+'-'+(x), obj).css({ opacity: 1, left: previousD, 'z-index': 100 });
						
						// slides in new slide
						$('#'+o.slideClass+'-'+(x), obj).animate({ left: 0 }, o.slideSpeed, o.easing, function() {
							$(this).addClass('current');
							$(this).css({ opacity: 1 });
							u = false;
							// Sets active state for pagination a
							setToActive(this);						
						});
						
						// slides out current slide
						$('.'+o.container, obj).find('.current').animate({ 'left': nextD }, o.slideSpeed, o.easing, function() {					
							$(this).removeClass('current');
							$(this).css({ opacity: 0, left: 0, 'z-index': 0 });
						});
						
					}
				return false;
				});
			});
    	}
	});
})(jQuery);