<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/head.jsp" %>
<title>新增员工</title>
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
							<th><a class="btn btn-info" href="/management/list" onclick="deleteCookie()">返回列表页</a></th>
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