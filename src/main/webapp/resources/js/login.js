var manage = {
		url : {
			list : function(key) {
				return '/management/list_' + key + '.action';
		}	
	}
}

/*$('#login').click(function(){
var username = $('#username').val();
var password = $('#password').val();
if(username && password){
	$.cookie('username', username);
	$.cookie('password', password);
	$.post(manage.url.list('queryByPage'), {"pageNum" : 1}, function(){
		
	});
}else{
	show.html('登录失败！！！');
	
	var username = $('#username').val();
	var password = $('#password').val();
	var show = $('#show');
	if(username == null || password == null){
		show.html('登录失败1111！！！');
	}
});*/








