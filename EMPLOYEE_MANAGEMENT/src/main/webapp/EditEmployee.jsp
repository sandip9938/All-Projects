<%@page import="com.sp.bean.EmployeeBean"%>
<%@page import="com.sp.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Employee</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #434343, #000000); /* Gradient background */
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

        input[type="text"] {
            margin: 10px 0;
            padding: 10px; /* Padding for input */
            border: 2px solid rgb(182, 182, 223);
            border-radius: 5px; /* Rounded corners */
            background-color: #1a1a1a; /* Dark input background */
            color: #e0e0e0; /* Light text color */
            font-size: 16px; /* Font size for input */
            width: 250px; /* Fixed width for input */
        }

        input[type="text"]:focus {
            border-color: rgb(182, 182, 223); /* Change border color on focus */
            outline: none; /* Remove default outline */
        }

        input[type="submit"] {
            margin: 20px 0;
            cursor: pointer;
            background-color: #212121;
            color: antiquewhite;
            border: 2px solid rgb(182, 182, 223);
            padding: 10px 20px; /* Padding for button */
            font-size: 18px; /* Font size for button */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
        }

        input[type="submit"]:hover {
            background-color: rgb(182, 182, 223); /* Lighten on hover */
            color: #212121; /* Dark text on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        @media (max-width: 600px) {
            input[type="text"] {
                width: 100%; /* Full width input on small screens */
            }
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
    <h2>Editing Employee: <%= eb.getEname() %></h2>
<%
    } else {
        out.println("<p>Employee information not available. Please select an employee to edit.</p>");
    }
%>
<form action="update" method="post">
    <input type="hidden" name="eid" value="<%= (eb != null) ? eb.getEid() : "" %>">
    <label for="bsal">Basic Salary:</label>
    <input type="text" id="bsal" name="bsal" placeholder="Update Salary" value="<%= (eb != null) ? eb.getEbsal() : "" %>" required>
    <input type="submit" value="Update Employee">
</form>
</body>
</html>


