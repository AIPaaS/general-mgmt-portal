
/**去掉最后的线条**/
$(function () {
$(".order-list-table  li:last").css("border-right","none");
});



//搜索区高级搜索 点击展开
$(document).ready(function(){
  $(".form-label ul li .sos a").click(function () {
	  $(".open ").slideToggle(100);
	  $(".nav-form ").toggleClass("reorder remove");
	  });
});
//点击结束

//商品管理table切换
$(function(){
$(".order-list-table ul li a").click(function () {
                $(".order-list-table ul li a").each(function () {
                    $(this).removeClass("current");
                });
                $(this).addClass("current");
            });
$('.order-list-table ul li a').click(function(){
  var index=$('.order-list-table ul li a').index(this);
      if(index==0){
     $('#date1').show();
  	$('#date2').hide();
  	$('#date3').hide();
  	$('#date4').hide();
  	$('#date5').hide();
  	$('#date6').hide();
  	
   }
   if(index==1){
     $('#date2').show();
  	 $('#date1').hide();
  	 $('#date3').hide();
  	 $('#date4').hide();
  	 $('#date5').hide();
  	 $('#date6').hide();
   }
   if(index==2){
     $('#date3').show();
  	 $('#date2').hide();
  	 $('#date1').hide();
  	 $('#date4').hide();
  	 $('#date5').hide();
  	 $('#date6').hide();   	
   }
   if(index==3){
     $('#date4').show();
  	 $('#date1').hide();
  	 $('#date2').hide();
  	 $('#date3').hide();
  	 $('#date5').hide();
  	 $('#date6').hide();   	
   }
    if(index==4){
     $('#date5').show();
  	 $('#date1').hide();
  	 $('#date2').hide();
  	 $('#date3').hide();
  	 $('#date4').hide();
  	 $('#date6').hide();   	
   }
    if(index==5){
     $('#date6').show();
  	 $('#date1').hide();
  	 $('#date2').hide();
  	 $('#date3').hide();
  	 $('#date4').hide();
  	 $('#date5').hide();   	
   }
  }); 
});
//table切换结束


/**商品编辑 其他设置 全国 部分 table**/
$(function(){
$(".radioa").click(function () {
	$('#check1').show();
	$('#check2').hide();
});
});

$(function(){
$(".radiob").click(function () {
	$('#check2').show();
	$('#check1').hide();
});
});
/**商品编辑 其他设置 全国 部分 table**/
$(function(){
$(".radioc").click(function () {
	$('#check3').show();
	$('#check4').hide();
});
});

$(function(){
$(".radiod").click(function () {
	$('#check4').show();
	$('#check3').hide();
});
});

//商品编辑展开更多 点击展开
$(function () {
    $(".cit-width .zk").click(function () {
		$(this).children('i').toggleClass("icon-angle-down  icon-angle-up");
		$(this).parents().children('.open').slideToggle(100);
    });
});	

//搜索已选中关闭
$(function(){
$(".form-label .fa-times").click(function () {
	$(this).parent('.img').hide();
	});
	});  

//商品编辑上传图片弹出框 点击展开
$(function () {
    $(".int-zk").click(function () {
		$(this).parents().children('.mouse-open').slideToggle(100);
    });
});	
$(function () {
    $(".newly-build").click(function () {
		$(this).parents().children('.newly-build-onclick').slideToggle(100);
    });
});	


//table 下拉
 $(function () {
    var st = 100;
     $(".center-hind").mouseenter(function () {
		$(this).parent().children('.showbj').slideToggle(100);
    });
    $('.center-hind').mouseleave(function () {
    	$(this).parent().children('.showbj').hide(1);
    });	
    
});
   