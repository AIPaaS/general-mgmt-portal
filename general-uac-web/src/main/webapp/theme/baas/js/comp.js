$(function(){
$(".login-wrapper-cnt-section .user").click(function () {
	$(".login-wrapper-cnt-section .user i").css('border-color', '#0697ef')
	$(".login-wrapper-cnt-section .user i").css('color', '#0697ef')
	$(".login-wrapper-cnt-section .user").css('border-color', '#0697ef')
	$(".login-wrapper-cnt-section .password i").css('border-color', '#666')
	$(".login-wrapper-cnt-section .password i").css('color', '#666')
	$(".login-wrapper-cnt-section .password").css('border-color', '#e4e4e4')
});});

$(function(){
$(".login-wrapper-cnt-section .password").hover(function () {
	$(".login-wrapper-cnt-section .password").css('border-color', '#e4e4e4')
});});




$(function(){
$(".login-wrapper-cnt-section .password").mouseout(function () {
	$(".login-wrapper-cnt-section .password i").css('border-color', '#666')
	$(".login-wrapper-cnt-section .password i").css('color', '#666')
	$(".login-wrapper-cnt-section .password").css('border-color', '#e4e4e4')
});});

$(function(){
$(".login-wrapper-cnt-section .user").mouseout(function () {
	$(".login-wrapper-cnt-section .user i").css('border-color', '#666')
	$(".login-wrapper-cnt-section .user i").css('color', '#666')
	$(".login-wrapper-cnt-section .user").css('border-color', '#e4e4e4')
});});


$(function(){
$(".login-wrapper-cnt-section .password").click(function () {
	$(".login-wrapper-cnt-section .password i").css('border-color', '#0697ef')
	$(".login-wrapper-cnt-section .password i").css('color', '#0697ef')
	$(".login-wrapper-cnt-section .password").css('border-color', '#0697ef')
	$(".login-wrapper-cnt-section .user i").css('border-color', '#666')
	$(".login-wrapper-cnt-section .user i").css('color', '#666')
	$(".login-wrapper-cnt-section .user").css('border-color', '#e4e4e4')
});
});

$(document).ready(function(){
$(".int-xlarge").click(function () {
   $(".login-wrapper-cnt-section ul .user i").animate({width:'26px',fontSize:'12px',marginTop:'18px'},100);
   $(".login-wrapper-cnt-section ul .password i").animate({width:'43px',fontSize:'20px',marginTop:'14px'},100);
});
});
$(document).ready(function(){
$(".int-xlarge-password").click(function () {
   $(".login-wrapper-cnt-section ul .password i").animate({width:'26px',fontSize:'12px',marginTop:'18px'},100);
   $(".login-wrapper-cnt-section ul .user i").animate({width:'43px',fontSize:'20px',marginTop:'14px'},100);
});
});

$(document).ready(function(){
$(".int-xlarge-password").mouseout(function () {
   $(".login-wrapper-cnt-section ul .password i").animate({width:'43px',fontSize:'20px',marginTop:'14px'},100);
});
});

$(document).ready(function(){
$(".int-xlarge").mouseout(function () {
   $(".login-wrapper-cnt-section ul .user i").animate({width:'43px',fontSize:'20px',marginTop:'14px'},100);
});
});

$(function(){
$(".regsiter-wrapper-cnt .user").click(function () {
	$(".regsiter-wrapper-cnt .user").css('border-color', '#0697ef')
	$(".regsiter-wrapper-cnt .password .icon-eye-open").css('color', '#666')
	$(".regsiter-wrapper-cnt .password").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .SMSidentifying").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .int-xlarge-identifying").css('border-color', '#e4e4e4')
	
});});

$(function(){
$(".regsiter-wrapper-cnt .password").click(function () {
	$(".regsiter-wrapper-cnt .password").css('border-color', '#0697ef')
	$(".regsiter-wrapper-cnt .password .icon-eye-open").css('color', '#0697ef')
	$(".regsiter-wrapper-cnt .user").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .SMSidentifying").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .int-xlarge-identifying").css('border-color', '#e4e4e4')
});});


$(function(){
$(".regsiter-wrapper-cnt .SMSidentifying").click(function () {
	$(".regsiter-wrapper-cnt .SMSidentifying").css('border-color', '#0697ef')
	$(".regsiter-wrapper-cnt .user").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .password .icon-eye-open").css('color', '#666')
	$(".regsiter-wrapper-cnt .password").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .int-xlarge-identifying").css('border-color', '#e4e4e4')
});});

$(function(){
$(".regsiter-wrapper-cnt .int-xlarge-identifying").click(function () {
	$(".regsiter-wrapper-cnt .int-xlarge-identifying").css('border-color', '#0697ef')
	$(".regsiter-wrapper-cnt .user").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .password .icon-eye-open").css('color', '#666')
	$(".regsiter-wrapper-cnt .password").css('border-color', '#e4e4e4')
	$(".regsiter-wrapper-cnt .SMSidentifying").css('border-color', '#e4e4e4')
});});


$(document).ready(function(){
$(".ctn-a").click(function(){
  $(".ctn-b").show();
  $(this).hide();
});
});

$(document).ready(function(){
$(".fuwu-close").click(function(){
  $(".pop-fuwu").hide(200);
});
});
$(document).ready(function(){
$(".fuwu").click(function(){
  $(".pop-fuwu").show(50);
});
});



