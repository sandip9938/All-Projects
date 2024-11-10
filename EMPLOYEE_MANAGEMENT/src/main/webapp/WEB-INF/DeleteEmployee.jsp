<%@page import="com.sp.bean.EmployeeBean"%>
<%@page import="com.sp.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete Employee</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<style>
body {
	background: linear-gradient(to right, #434343, #000000);
	/* Gradient background */
	color: white;
	font-family: 'Roboto', sans-serif; /* Modern font */
	margin: 0;
	padding: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

h2 {
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
	align-items: center; /* Center align the form elements */
	background-color: #2a2a2a; /* Dark background for the form */
	padding: 20px;
	border-radius: 10px; /* Rounded corners */
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5); /* Subtle shadow effect */
}

p {
	margin: 10px 0; /* Space around paragraphs */
}

input[type="submit"] {
	margin: 20px 0;
	cursor: pointer;
	background-color: #c0392b; /* Red background for delete */
	color: white;
	border: 2px solid rgb(182, 182, 223);
	padding: 10px 20px; /* Padding for button */
	font-size: 18px; /* Font size for button */
	border-radius: 5px; /* Rounded corners */
	transition: background-color 0.3s, transform 0.3s;
	/* Smooth transitions */
}

input[type="submit"]:hover {
	background-color: rgb(182, 182, 223); /* Lighten on hover */
	color: #c0392b; /* Dark text on hover */
	transform: scale(1.05); /* Slightly enlarge on hover */
}

@media ( max-width : 600px) {
	form {
		width: 90%; /* Responsive form width on small screens */
	}
}
</style>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	EmployeeBean eb = (EmployeeBean) request.getAttribute("ebean");

	if (eb != null) {
	%>
	<h2>
		Are you sure you want to delete the employee:
		<%=eb.getEname()%>?
	</h2>
	<p>
		ID:
		<%=eb.getEid()%></p>
	<p>
		Basic Salary:
		<%=eb.getEbsal()%></p>
	<form action="delete" method="post">
		<input type="hidden" name="eid"
			value="<%=(eb != null) ? eb.getEid() : ""%>"> <input
			type="submit" value="Confirm Delete">
	</form>

	<%
	} else {
	out.println("<p>Employee information not available. Please select an employee to delete.</p>");
	}
	%>
</body>
</html>
