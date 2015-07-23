
/**
 * index页面初始化
 */
$(document).ready(function() {
	
	var data = {};
	var ajaxobj = new AjaxObj();
	ajaxobj.url = "";
	ajaxobj.data = data;
	ajaxobj.type = "POST";
	
	ajaxobj.AfterRequest = function() {
		
	}
	ajaxobj.sendRequest();
});