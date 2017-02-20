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
				<h2>员工列表</h2>
			</div>

			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th><button class="btn btn-info">删除</button></th>
							<th></th><th></th><th></th><th></th><th></th><th></th><th></th>
							<th><a class="btn btn-info" href="/management/staff" onclick="deleteCookie()">员工管理</a></th>
							<th><a class="btn btn-info" href="/management/position" onclick="deleteCookie()">职位管理</a></th>
						</tr>
						<tr>
							<th></th>
							<th>ID</th>
							<th>姓名</th>
							<th>性别</th>
							<th>职位</th>
							<th>薪资</th>
							<th>Email</th>
							<th>入职时间</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					
					<tbody>
						<#if staffList ??>
						<#list staffList as staff>
							<tr>
								<td>
									<div class="col-lg-6">
										<div class="input-group">
												<input type="checkbox">
										</div><!-- /input-group -->
									</div><!-- /.col-lg-6 --><br>
								</td>
								<td>${staff.id!}</td>
								<td>${staff.name!}</td>
								<td>${staff.gender!}</td>
								<td>${staff.job!}</td>
								<td>${staff.salary!}</td>
								<td>${staff.email!}</td>
								<td>${staff.regDate?string('yyyy-MM-dd')!}</td>
								<#--<td><button class="btn btn-info">修改</button></td>-->
								<td></td>
								<td><button class="btn btn-info" onclick="deleteStaffById(${staff.id!})">删除</button></td>
							</tr>
						</#list>
					</#if>
					</tbody>

					<tfoot>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th>
							</th>
							<th>
								
							</th>
							<th></th>
						</tr>
					</tfoot>
				</table>
				<div>
					<div class="col-lg-offset-8 input-group">
						<a onclick="firstPage">首页</a>&nbsp;&nbsp;
						<a onclick="firstPage">上一页</a>&nbsp;&nbsp;
						<a onclick="firstPage">下一页</a>&nbsp;&nbsp;
							<input type="text" class="form-control" style="max-width:50%;float:right">
							<span class="input-group-btn">
								<button class="btn btn-default">Go</button>
							</span>
					</div>
				</div>
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
