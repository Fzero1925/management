var manage = {

	url : {
		list : function(key) {
			return '/management/list!' + key;
		},
		
		addStaff : function(key){
			return '/management/staff!' + key;
		}
	}
}

function deleteStaffById(id){
	$.cookie("staffId", id)
	$.post(manage.url.list("deleteById"), {}, function(){
		window.location.reload();//刷新页面
	})
}

//URLEncoder.encode()
function addStaff(){
	var name = $('#name').val();
	var email = $('#email').val();
	var gender = $('#gender').val();
	var salary = $('#salary').val();
	var job = $('#job').val();
	$.cookie("name", name);
	$.cookie("gender", gender);
	$.cookie("job", job);
	$.cookie("salary", salary);
	$.cookie("email", email);
	$.post(manage.url.addStaff("addStaff"), {}, function(){
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
	})
}

function deleteCookie(){
	document.cookie = "name=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "gender=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "job=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "salary=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "email=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	document.cookie = "staffId=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
}









