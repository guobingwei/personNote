/**
 * 登录界面处理过程
 */
$(document).ready(function(){
	
});

$("#login-button").click(function(){
	var userName = $("#userName").val();
	var passWord = $("#passWord").val();
	var User = {};
	User.username = userName;
	User.password = passWord;
	var data = {};
	data = User;
	var ajaxobj = new AjaxObj();
	ajaxobj.data = data;
	ajaxobj.type = "POST";
	ajaxobj.url = "../user/login";
	ajaxobj.AfterRequest = function() {
		var backData = ajaxobj.backdata;
		if(backData.loginResult) {
			window.location.href = '../html/index.html';
		}else {
			window.location.href = "login.html";
		}
	}
	ajaxobj.sendRequest();
});
