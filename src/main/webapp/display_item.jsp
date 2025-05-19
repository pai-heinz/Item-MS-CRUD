<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Item Management</title>
<style type="text/css">
	.color{
		height: 100vh;
	}
</style>
</head>
<body >
	<center><jsp:include page="header.html"></jsp:include></center>
	<br>
	
	<table class="table table-bordered"  >
		<tr>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>Item Price</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach items="${list }" var="data">
			<tr>
				<td>${data.itemCode }</td>
				<td>${data.itemName }</td>
				<td>${data.itemPrice }</td>
				<td>
					<a href="updateItemServlet?code=${data.itemCode }" class="btn btn-warning">Update</a> | <a href="deleteItemServlet?code=${data.itemCode }" class="btn btn-danger">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>