<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<form:form id="UpdateBugForm" modelAttribute="bug" action="UpdateBugProcess"
			method="post">	
	<table id="employee">
		<tr>
			<th>BUG NAME</th>
			<th>CODER</th>
			<th>TESTER</th>
			<th>PROJECT</th>
			<th>STATUS</th>
			<th>SOLUTION</th>
			
		</tr>
		<tbody>
		
			<c:forEach var="Testerbugs" items="${Testerbugs}" varStatus="status">
				 <td>${Testerbugs.bugName}</td>
				<td>${Testerbugs.bugCoder}</td>
				<td>${Testerbugs.bugTester}</td>
				<td>${Testerbugs.bugProject}</td>
				<td>${Testerbugs.bugStatus}</td>
				<td>${Testerbugs.bugSolution}</td>
				
				<tr>
					<td><form:label path="bugStatus">STATUS</form:label></td>
					<form:select path="bugStatus" name="bugStatus" id="bugStatus">
						<option>OPEN</option>
						<option>PENDING</option>
						<option>CLOSED</option>
					</form:select>
				</tr>
				<form:button id="bug" name="bug">UPDATE</form:button>
				
			<tr></tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>

</body>
</html>
