<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
#employee {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#employee td, #employee th {
  border: 1px solid #ddd;
  padding: 8px;
}

#employee tr:nth-child(even){background-color: #f2f2f2;}

#employee tr:hover {background-color: #d8f2f2;}

#employee th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #6880b0;
  color: white;
}
</style>
</head>
<body>
</head>
<body>
	<table id="employee">
		<tr>
			<th>EMIL</th>
			<th>PASSWORD</th>
			<th>NAME</th>
			<th>DESIGNATION</th>
			<th>PROJECT ID</th>
			<th>PHONE</th>
		</tr>
		<tbody>
			<c:forEach var="emp" items="${emp}" varStatus="status">
				<td>${emp[0]}</td>
				<td>${emp[1]}</td>
				<td>${emp[2]}</td>
				<td>${emp[3]}</td>
				<td>${emp[4]}</td>
				<td>${emp[5]}</td>
				<td>		
				<form modelAttribute="Employee" action="removeEmployee" method="post">
				<button name="EmployeeEmail" value="${emp[0]}" type="submit">REMOVE</button>
				</form>
				</td>
				<tr></tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
