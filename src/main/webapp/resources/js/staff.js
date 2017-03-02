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









