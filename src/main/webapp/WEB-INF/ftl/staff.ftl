<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"]/>
<!DOCTYPE html>
<html>
<head>
	<title>管理页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
	<!-- 引入 Bootstrap -->
	<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
	<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
	<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
	<!--[if lt IE 9]>
	    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>员工管理</h2>
			</div>

			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>
								<div class="input-group">
									<input type="text" calss="form-control" id="name" placeholder="姓名">
								</div>
							</th>
							<th>
								<form role="form">
									<div class="form-group">
										<select class="form-control" id="gender">
											<option>男</option>
											<option>女</option>
										</select>
									</div>
								</form>
							</th>
							<th>
								<form role="form">
									<div class="form-group">
										<select class="form-control" id="job">
											<option>Java</option>
											<option>前端</option>
											<option>PHP</option>
											<option>产品</option>
										</select>
									</div>
								</form>
							</th>
							<th>
								<div class="input-group">
									<input type="text" calss="form-control" id="salary" placeholder="薪资">
								</div>
							</th>
							<th>
								<div class="input-group">
									<input type="text" calss="form-control" id="email" placeholder="邮箱">
								</div>
							</th>
							<th><button class="btn btn-info" onclick="addStaff()">提交</button></th>
							<th><a class="btn btn-info" href="/management/list">返回列表页</a></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- 使用CDN获取公共js  -->
<!-- jQuery cookie操作插件 -->
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>

<!-- 引入外部js -->	
<script src="resources/js/staff.js" type="text/javascript"></script>

</html>
