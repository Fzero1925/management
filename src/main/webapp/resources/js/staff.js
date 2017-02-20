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
	$.post(manage.url.list("deleteById"), {}, function(){
		$.cookie("staffId", id)
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
	$.post(manage.url.addStaff("addStaff"), {}, function(){
		$.cookie("name", name);
		$.cookie("gender", gender);
		$.cookie("job", job);
		$.cookie("salary", salary);
		$.cookie("email", email);
		window.location.reload();//刷新页面
	})
}









