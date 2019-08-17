<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

#myInput {
	background-image: url('/css/searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

#myTable {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
	font-size: 18px;
}

#myTable th, #myTable td {
	text-align: left;
	padding: 12px;
}

#myTable tr {
	border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>

	<h2>BUGS</h2>

	<input type="text" id="myInput" onkeyup="myFunction()"
		placeholder="Search for BUGS" title="Type in a name">

	<table id="myTable">
		<tr class="header">
			<th>BUG NAME</th>
			<th>CODER</th>
			<th>TESTER</th>
			<th>PROJECT</th>
			<th>STATUS</th>
			<th>SOLUTION</th>

		</tr>
		<c:forEach var="bugs" items="${bugs}" varStatus="status">
			<td>${bugs.bugName}</td>
			<td>${bugs.bugCoder}</td>
			<td>${bugs.bugTester}</td>
			<td>${bugs.bugProject}</td>
			<td>${bugs.bugStatus}</td>
			<td>${bugs.bugSolution}</td>

			<tr></tr>
		</c:forEach>
	</table>
	<script>
		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>

</body>
</html>
