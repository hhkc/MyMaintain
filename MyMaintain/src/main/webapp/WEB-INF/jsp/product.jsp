<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="bootstrap/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<title>产品信息</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<table class="table table-bordered">
				<tr>
					<th>序号</th>
					<th>炉次</th>
					<th>任务单</th>
					<th>数量</th>
					<th>炉次状态</th>
					<th>工步</th>
					<th>创建时间</th>
				</tr>
				<c:forEach items="${products }" var="product" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${product.lot_id }</td>
						<td>${product.instance_id }</td>
						<td>${product.qty1 }</td>

						<c:choose>
						
					
							<c:when test="${product.lot_status }=='WAITING'">
								<td><span class="badge badge-primary">${product.lot_status }</span></td>
							</c:when>
							<c:when test="${product.lot_status }=='RUNNING'">
								<td><span class="badge badge-success">${product.lot_status }</span></td>
							</c:when>
							<c:when test="${product.lot_status }=='HOLD'">
								<td><span class="badge badge-danger">${product.lot_status }</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="badge badge-danger">${product.lot_status }</span></td>
							</c:otherwise>
						</c:choose>
						<td>${product.instance_desc }</td>
						<td>${product.created_timestamp }</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>