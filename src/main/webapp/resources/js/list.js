var manage = {

	url : {
		list : function(key) {
			return '/management/list_' + key + '.action';
		},
		
		addStaff : function(key){
			return '/management/staff_' + key + '.action';
		},
		
		page : function(key){
			return '/management/list_' + key + '.action';
		}
		
	}
}



function deleteStaffById(id){
	/*$.cookie("staffId", id)*/
	$.post(manage.url.list("deleteById"), {"id" : id}, function(){
		window.location.reload();//刷新页面
	});
}

/*function active(pageNum){
switch(pageNum % 5){
case 1:
	$("#li1").attr("class", "active");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "");
	$("#li5").attr("class", "");
	break;
case 2:
	$("#li1").attr("class", "");
	$("#li2").attr("class", "active");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "");
	$("#li5").attr("class", "");
	break;
case 3:
	$("#li1").attr("class", "");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "active");
	$("#li4").attr("class", "");
	$("#li5").attr("class", "");
	break;
case 4:
	$("#li1").attr("class", "");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "active");
	$("#li5").attr("class", "");
	break;
case 5:
	$("#li1").attr("class", "");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "");
	$("#li5").attr("class", "active");
	break;
}
}*/


$(document).ready(function(){

/*	$.post(manage.url.list("queryByPage"), {}, function(){
});*/

$("#first").click(function(){
	$.cookie("pageNum", 1);
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
});

/*	$("#pre").click(function(){
	//当前页数判断
	if($.cookie("pageNum") == 1){
		alert("已经在第一页中");
	}else if($.cookie("pageNum") > 1){
		var num = $.cookie("pageNum") - 1;
		$.cookie("pageNum", num);
		$.post(manage.url.page("queryByPage"), {}, function(){})
	}else{
		alert('没有负数页码');
	}
});*/

/*	$("#num1").click(function(){
	$.cookie("pageNum", 1);
	active($.cookie("pageNum"));
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
});

$("#num2").click(function(){
	$.cookie("pageNum", 2);
	active($.cookie("pageNum"));
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
});

$("#num3").click(function(){
	$.cookie("pageNum", 3);
	active($.cookie("pageNum"));
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
});

$("#num4").click(function(){
	$.cookie("pageNum", 4);
	active($.cookie("pageNum"));
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
});

$("#num5").click(function(){
	$.cookie("pageNum", 5);
	active($.cookie("pageNum"));
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
});*/
});

function go(sumPage){
var pageNum = $('#inputGo').val();
if(pageNum == null){
	alert("没有负数页码！！！");
}else if(isNaN(pageNum)){
	alert("请输入数字！！！");
}else if(pageNum > sumPage){
	alert("没有数据！！！");
}else if(pageNum < 1){
	alert("没有输入页码！！！");
}else{
	$.post(manage.url.page("queryByPage"), {"pageNum" : pageNum}, function(){
		location.href="/management/list_queryByPage.action?pageNum=" + pageNum;
	});
}
}

/*$('#go').click(function(){
var pageNum = $('#inputGo').val();
console.log(pageNum);
if($.cookie("pageNum")){
	$.cookie("pageNum", "");
}
if(pageNum == null){
	alert("没有输入页码！！！");
}else{
	$.post(manage.url.page("queryByPage"), {"pageNum" : pageNum}, function(){
		if($.cookie("pageInfo") == ""){
			location.href="/management/list_queryByPage.action?pageNum=" + pageNum;
		}else
		if($.cookie("pageInfo") == "noPage"){
			alert("没有负数页码！！！");
			$.cookie("pageInfo", "");
		}else if($.cookie("pageInfo") == "noData"){
			alert("没有数据！！！");
			$.cookie("pageInfo", "");
		}
	});
}
});*/

function deleteMore(){
var mainForm = $('#mainForm');
mainForm.attr("action", "/management/list_deleteBatch.action");
mainForm.submit;

/*alert($(':checkbox[name=staff]:checked'));*/
}














