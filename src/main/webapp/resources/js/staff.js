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
		},
		
	}
	
/*	init : function(params){
		var currentPage = params['currentPage'];
	}*/
}


function deleteStaffById(id){
	/*$.cookie("staffId", id)*/
	$.post(manage.url.list("deleteById"), {"id" : id}, function(){
		window.location.reload();//刷新页面
	});
}

//URLEncoder.encode()
function addStaff(){
	var name = $('#name').val();
	var email = $('#email').val();
	var gender = $('#gender').val();
	var salary = $('#salary').val();
	var job = $('#job').val();
	/*$.cookie("name", name);
	$.cookie("gender", gender);
	$.cookie("job", job);
	$.cookie("salary", salary);
	$.cookie("email", email);*/
	if(salary && !isNaN(salary)){
		$.post(manage.url.addStaff("addStaff"), {
			"name" : name,
			"gender" : gender,
			"job" : job,
			"salary" : salary,
			"email" : email
		}, function(){
	/*		$.cookie("name", name);
			$.cookie("gender", gender);
			$.cookie("job", job);
			$.cookie("salary", salary);
			$.cookie("email", email);*/
	/*		document.cookie = "name=" + name +";"
			document.cookie = "gender=" + gender +";";
			document.cookie = "job=" + job +";";
			document.cookie = "salary=" + salary +";";
			document.cookie = "email=" + email +";";*/
			window.location.reload();//刷新页面
			
	/*		var time = new Date();
			time.setTime(time.getTime() - 1000);//当前时间减去一秒，使Cookie过期
			$.cookie("name", name, {expires:time.toGMTString()});
			$.cookie("gender", gender, {expires:time.toGMTString()});
			$.cookie("job", job, {expires:time.toGMTString()});
			$.cookie("salary", salary, {expires:time.toGMTString()});*/
		});
	}else{
		alert("工资栏应该填写数字！！！");
	}
	
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

function firstPage(){
	$.cookie("pageNum", 1);
	$.post(manage.url.page("queryByPage"), {}, function(){
		window.location.reload();
	});
}

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



function deleteCookie(){
	document.cookie = "name=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "gender=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "job=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "salary=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "email=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "staffId=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
}

//测试代码
function show(){
	//获取第一个a标签的文本，最好使用id，这里使用标签获取
    document.getElementsByTagName("a")[0].innerText;
    
    //改变第一个a标签的文本
    documen.getElementsByTagName("a")[0].innerText = 2;
}









