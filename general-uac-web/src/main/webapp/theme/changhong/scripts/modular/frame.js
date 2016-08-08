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
	
	
	
	
	
	
	
	
}
