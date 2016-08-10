window.onload=function(){
	//提示操作弹出框
	var oPo=document.getElementById('popup');
	var oOpe=document.getElementById('operation');
	var oClosebtn=document.getElementById('closebtn');
	var oXclose=document.getElementById('xclose');
	
	oOpe.onclick=function(){
		oPo.style.display='block';
	}
	oClosebtn.onclick=function(){
		oPo.style.display='none';
	}
	oXclose.onclick=function(){
		oPo.style.display='none';
	};
	
	//提示弹出框
var oChoice=document.getElementById('choice');
var oCbtn=document.getElementById('choice-btn');
var oXclosea=document.getElementById('xclose-a');
	oCbtn.onclick=function(){
		oChoice.style.display='block';
	}
	oXclosea.onclick=function(){
		oChoice.style.display='none';
	};
	
	//树状弹出框
	var oTree=document.getElementById('tree');
	var oTreebtn=document.getElementById('tree-btn');
	var oTreeclose=document.getElementById('tree-close');
	
	oTreebtn.onclick=function(){
		oTree.style.display='block';
	}
	oTreeclose.onclick=function(){
		oTree.style.display='none';
	};

};
	var aD=document.getElementById('addcity');
	var aF=document.getElementById('addfrei');
	aD.onclick=function(){
		if(aF.style.display=='block'){
			aF.style.display='none';
		}else{
			aF.style.display='block';
		}	
	};

//类目属性 table 点击展开
$(function () {
    $(".relation-special table tr .click a").click(function () {
		$(this).children('i').toggleClass("fa-minus fa-plus");
		$(this).parent().parent().parent().parent().parent().parent().parent().children('.zhank').slideToggle(100);
    });
});	

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


//已选中关闭
$(function(){
$(".form-label .close1").click(function () {
	$(".form-label").hide(300)
	});
	});