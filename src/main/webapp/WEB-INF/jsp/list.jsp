<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/head.jsp" %>
<title>员工列表页</title>
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
						<s:iterator value="staffList" var="staff">
							<tr>
								<td>
									<div class="col-lg-6">
										<div class="input-group">
												<input type="checkbox">
										</div><!-- /input-group -->
									</div><!-- /.col-lg-6 --><br>
								</td>
								<td><s:property value="#staff.id"/></td>
								<td><s:property value="#staff.name"/></td>
								<td><s:property value="#staff.gender"/></td>
								<td><s:property value="#staff.job"/></td>
								<td><s:property value="#staff.salary"/></td>
								<td><s:property value="#staff.email"/></td>
								<td><s:date name="#staff.regDate" format="yyyy-MM-dd"/></td>
								<!-- <td><button class="btn btn-info">修改</button></td> -->
								<td></td>
								<td><button class="btn btn-info" onclick="deleteStaffById()">删除</button></td>
							</tr>
						</s:iterator>
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
					<div class="col-lg-offset-6 input-group" >
						<ul class="pagination" >
							<li><span class="btn btn-default" id="first">首页</span></li>
							<li><span class="btn btn-default" id="pre">上一页</span></li>
							<li id="li1"><span class="btn btn-default" id="num1">1</span></li>
							<li id="li2"><span class="btn btn-default" id="num2">2</span></li>
							<li id="li3"><span class="btn btn-default" id="num3">3</span></li>
							<li id="li4"><span class="btn btn-default" id="num4">4</span></li>
							<li id="li5"><span class="btn btn-default" id="num5">5</span></li>
							<li><span class="btn btn-default" id="next">下一页</span></li>
								<input type="text" class="form-control" style="max-width:15%;">
								<span class="input-group-btn">
									<button class="btn btn-default" id="go">Go</button>
								</span>
						</ul>
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