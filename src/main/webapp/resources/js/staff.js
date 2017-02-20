var manage = {

	url : {
		list : function(key) {
			return '/management/list!' + key;
		}
	}
}

function deleteStaffById(id){
	$.post(manage.url.list("deleteById"), {}, function(){
		$.cookie("staffId", id)
		window.location.reload();//刷新页面
	})
}