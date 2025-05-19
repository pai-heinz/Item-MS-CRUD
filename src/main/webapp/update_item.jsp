<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Item Management</title>
<style type="text/css">
	.center{
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
	<center>
		<jsp:include page="header.html"></jsp:include>
		<div style="color: red;">${error }</div>
	</center><br>
	
	<form action="updateItemServlet" method="post">
		<table class="center table">
			<tr>
				<td>Item Code</td>
				<td> <input type="text" name="code" value="${res.itemCode }" readonly> </td>
			</tr>
			
			<tr>
				<td>Item Name</td>
				<td> <input type="text" name="name" value="${res.itemName }"> </td>
			</tr>
			
			<tr>
				<td>Item Price</td>
				<td> <input type="text" name="price" value="${res.itemPrice }"> </td>
			</tr>
			
			<tr> 
				<td></td>
				<td> <input type="submit" value="Update" class="btn btn-warning"> </td>
			</tr>
		</table>
	</form>
</body>
</html>