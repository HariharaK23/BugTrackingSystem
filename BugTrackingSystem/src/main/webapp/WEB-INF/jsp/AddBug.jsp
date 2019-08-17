<%@ page import="java.sql.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	ResultSet resultset, resultset2 = null;
%>

<HTML>
<HEAD>
<TITLE>Select element drop down box</TITLE>
</HEAD>

<BODY BGCOLOR=##f89ggh>

	<%
		try {
			String URL = "jdbc:mysql://localhost:3306/bugtracker";
			String user = "root";
			String password = "";
			Connection connection = DriverManager.getConnection(URL, user, password);

			Statement statement = connection.createStatement();
			String designation = "Coder";

			resultset = statement.executeQuery("select * from employee where emp_designation='"+designation+"'");
			//resultset2 = statement.executeQuery("select * from project");
	%>

	<center>
		<h1>ADD THE BUG DETAILS</h1>
		<form:form id="AddBugForm" modelAttribute="bug" action="AddBugProcess"
			method="post">
			<table align="center">
				<tr>
					<td><form:label path="bugName">BUG NAME</form:label></td>
					<td><form:input path="bugName" name="bugName" id="bugName" />
					</td>
				</tr>
				<tr><br><br>
				
						<form:select path="bugCoder" name="bugCoder" id="bugCoder">
						<%
							while (resultset.next()) {
						%>
						<option><%=resultset.getString(3)%></option>
						<%
							}
						%>
					</form:select>
				</tr>
				<tr>
					<td><form:label path="bugTester">TESTER</form:label></td>
					<td><form:input path="bugTester" name="bugTester"
							id="bugTester" /></td>
				</tr>
				<tr>
					<td><form:label path="bugProject">PROJECT</form:label></td>
					<form:select path="bugProject" name="bugProject" id="bugProject">
						<option>Library Management</option>
						<option>Student Managment</option>
						<option>Bug Tracker</option>
					</form:select>
				</tr> 
				<tr>
					<td><form:label path="bugStatus">STATUS</form:label></td>
					<form:select path="bugStatus" name="bugStatus" id="bugStatus">
						<option>OPEN</option>
						<option>PENDING</option>
						<option>CLOSED</option>
					</form:select>
				</tr>
				<tr>
					<td></td>
					<td align="left"><form:button id="bug" name="bug">ADD</form:button>
					</td>
				</tr>
				<tr></tr>
			</table>
		</form:form>
	</center>

	<%
		//**Should I input the codes here?**
		} catch (Exception e) {
			out.println("wrong entry" + e);
		}
	%>

</BODY>
</HTML>