
/**
 * ajax组件封装
 */
function AjaxObj() {
	var AjaxObj = {};
	AjaxObj.type = "POST";
	AjaxObj.dataType = "json";
	AjaxObj.data = "";
	AjaxObj.url = "";
	AjaxObj.backdata = "";
	
	//处理请求之后的逻辑
	AjaxObj.AfterRequest = function() {}
	
	//请求过程
	AjaxObj.sendRequest = function() {
		$.ajax({
			type : AjaxObj.type,
			dataType : AjaxObj.dataType,
			data : AjaxObj.data ? eval(AjaxObj.data) : "",   //json字符串转为json对象
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : AjaxObj.url,
			// 同步async: false,（默认是true）;
			// 如上：false为同步，这个方法中的Ajax请求将整个浏览器锁死，
			// 只有test.jsp执行结束后，才可以执行其它操作。
			async : false,
			success : function(data) {
				AjaxObj.backdata = data;
				AjaxObj.AfterRequest();
			},
			error : function() {
				alert("服务器发生故障，请尝试重新登录！");
			}
		});
	}
	return AjaxObj;
}