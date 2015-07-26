
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
			//async : false,
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

/**
 * 模板替换规则
 * @param obj
 * @returns {string}
 */
String.prototype.temp = function(obj) {
    //返回替换后的值
    return this.replace(/\$\w+\$/gi, function(matchs) {
        //matchs输出符合正则表达式"$\w+\$"的所有字符串,如$data$
        //matchs.replace(/\$/g, "")就是将$替换为"",如$data$替换后为data
        var returns = obj[matchs.replace(/\$/g, "")];
        return (returns + "") == "undefined"? "": returns;
    });
};
