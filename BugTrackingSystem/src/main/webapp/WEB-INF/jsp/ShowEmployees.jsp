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
			<th>NAME</th>
			<th>DESIGNATION</th>
			<th>PHONE</th>
			<th>PROJECT ID</th>
			
		</tr>
		<tbody>
			<c:forEach var="employees" items="${employees}" varStatus="status">
				 <td>${employees.employeeEmail}</td>
				<td>${employees.employeeName}</td>
				<td>${employees.employeeDesignation}</td>
				<td>${employees.employeePhone}</td>
				<td>${employees.employeeProjectId}</td>
				<td>		
				<form modelAttribute="Employee" action="removeEmployee" method="post">
				<button name="employeeEmail" value="${employee[0]}" type="submit">REMOVE</button>
				</form>
				<form modelAttribute="Employee" action="updateEmployee" method="post">
				<button name="employeeEmail" value="${employee[0]}" type="submit">UPDATE</button>
				</form>
				</td>
				<tr></tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
