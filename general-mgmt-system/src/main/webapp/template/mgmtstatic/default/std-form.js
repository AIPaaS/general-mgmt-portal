$(function(){
	var formValidator=_initValidate();
	$(":input").bind("focusout",function(){
		formValidator.element(this);
	});
	
	$("#binSubmit").bind("click",function(){
	 _submitForm();
});

});

function _initValidate(){    		
    		var formValidator=$("#dataForm").validate({
    			rules: {
    				//productCatName: "required",
    				departName: {
    					required:true,
    					maxlength:10,
    					minlength:3,
						regexp: /^\d{4}-\d{2}-\d{2}$/
    					},
    				departType: {
    					required:true
    					},
    				parentDepart: {
    					required: true,
    					digits:true,
    					min:1,
    					max:100
    				},
    				province: {
    					required: true
    				},
    				city:{
    					required: true
    				}
    			},
    			messages: {
    				departName: {
    					required:"请输入类目名称",
    					maxlength:"最大长度不能超过{0}",
    					minlength:"最小长度不能小于{0}"
    					},
    				departType: {
    					required:"请输入类目名称首字母",
    					maxWords:"单词格式超了",
    					minlength:"最小长度为{0}",
    					regexp: "日期格式不对111"
    						
    				}
    				,
    				parentDepart: {
    					required: "请输入排序",
    					digits: "只能输入数字",
    					min:"最小值为{0}",
    					max:"最大值为{0}"
    				},
    				province: {
    					required: "请输入是否存在子分类"
    				},
    				city:{
    					required: "请输入开始日期"     						
    				}
    			}
    		});
    		
    		return formValidator;
    	}
		
		
		
function _submitForm(){
	var formValidator=_initValidate();
	formValidator.form();
	if(!$("#dataForm").valid()){
		//alert('验证不通过！！！！！');
		return;
	}
}		