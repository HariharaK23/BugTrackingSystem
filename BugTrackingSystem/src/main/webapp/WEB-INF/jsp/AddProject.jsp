<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=email], [type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
<body>
	<div>
		<div style="padding-left: 16px"></div>
		<form action="AddProjectProcess" method="post">
			<label for="projectId">PROJECT ID</label>
			<input type="number"name="projectId" > 
			
			<label for="projectName">PROJECT NAME</label>
			<input type="text" name="projectName">	
			<input type="submit" value="ADD">
		</form>
		<p>${message}</p>
	</div>


</body>
</html>
