<%@page import="com.sp.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
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

        h1 {
            margin-bottom: 20px;
        }

        input {
            margin: 10px;
            padding: 10px; /* Improved padding */
            border-radius: 5px; /* Rounded corners */
            border: 1px solid #ccc; /* Subtle border */
            width: 300px; /* Fixed width */
        }

        button {
            justify-content: center;
            margin: 20px;
            cursor: pointer;
            background-color: #212121;
            color: antiquewhite;
            border: 2px solid rgb(182, 182, 223);
            padding: 10px 20px; /* Improved padding */
            font-size: 16px; /* Font size for button */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
        }

        button:hover {
            background-color: rgb(182, 182, 223); /* Lighten on hover */
            color: #212121; /* Dark text on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        .message {
            color: #ffcc00; /* Color for messages */
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>Add Employee</h1>

    <%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    String msg = (String) request.getAttribute("msg");

    if (msg != null) {
    %>
        <div class="message"><%= msg %></div>
    <%
    }
    %>

    <a href="employee.html"><button>Add Employee</button></a>
    <a href="view"><button>View All Employees</button></a>
    <a href="logout"><button>Log Out</button></a>
</body>
</html>

