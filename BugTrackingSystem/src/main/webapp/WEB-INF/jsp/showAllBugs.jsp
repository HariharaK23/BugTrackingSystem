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
			<th>BUG NAME</th>
			<th>PROJECT ID</th>
			<th>DEVELOPER</th>
			<th>TESTER</th>
			<th>STATUS ID</th>
			<th>SOLUTION</th>
		</tr>
		<tbody>
			<c:forEach var="bugs" items="${bugs}" varStatus="status">
				<td>${bugs[0]}</td>
				<td>${bugs[1]}</td>
				<td>${bugs[2]}</td>
				<td>${bugs[3]}</td>
				<td>${bugs[4]}</td>
				<td>${bugs[5]}</td><tr></tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
