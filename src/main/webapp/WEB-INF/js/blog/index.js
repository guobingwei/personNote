
/**
 * index页面初始化
 */
$(document).ready(function() {
	
	var data = {};
	var ajaxobj = new AjaxObj();
	ajaxobj.url = "../article/articleList.do";
	ajaxobj.data = data;
	ajaxobj.type = "GET";
	
	ajaxobj.AfterRequest = function() {
		indexInit(ajaxobj.backdata);
	}
	ajaxobj.sendRequest();
});

/**
 * index页面初始化函数
 */
function indexInit(data) {
	//处理时间格式
	for(var i=0;i<data.length;i++){
        data[i]["publishDate"]= new Date( data[i].publishDate).toLocaleString().replace(/\//g, '-').substr(0,10);
    }
	var blogTemplate = $("#blogList").html();
	var blogContent = '';
	for(var i=0;i<data.length;i++){
		blogContent += blogTemplate.temp(data[i]);
	}
	$("#blogList").html(blogContent);
}

