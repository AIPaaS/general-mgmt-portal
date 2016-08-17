//类目属性 table 点击展开
$(function () {
    $(".relation-special table tr .click a").click(function () {
		$(this).children('i').toggleClass("fa-minus fa-plus");
		$(this).parent().parent().parent().parent().parent().parent().parent().children('.zhank').slideToggle(100);
    });
});	
