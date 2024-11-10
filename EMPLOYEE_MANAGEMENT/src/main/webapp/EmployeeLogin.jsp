<%@page import="com.sp.bean.EmployeeBean"%>
<%@page import="com.sp.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #434343, #000000); /* Gradient background */
            color: rgb(240, 238, 234);
            font-family: 'Roboto', sans-serif; /* Modern font */
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        button {
            justify-content: center;
            margin: 10px;
            cursor: pointer;
            background-color: #212121;
            color: antiquewhite;
            border: 2px solid rgb(182, 182, 223);
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
        }

        button:hover {
            background-color: rgb(182, 182, 223);
            color: #212121; /* Dark text on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table, th, td {
            border: 1px solid rgb(182, 182, 223);
        }

        th, td {
            padding: 15px;
            text-align: left;
            font-size: 16px;
        }

        th {
            background-color: #212121;
            color: antiquewhite;
        }

        tr:nth-child(even) {
            background-color: #4f4f4f; /* Alternate row color */
        }

        tr:hover {
            background-color: rgba(182, 182, 223, 0.2); /* Highlight row on hover */
        }

        @media (max-width: 600px) {
            button {
                width: 100%; /* Full width buttons on small screens */
                font-size: 16px;
            }

            th, td {
                font-size: 14px; /* Smaller text on small screens */
            }
        }
    </style>
</head>
<body>
<%
EmployeeBean eb = (EmployeeBean) session.getAttribute("ebean");

if (eb != null) {
%>
    <h2>Welcome Employee: <%= eb.getEname() %></h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Basic Salary</th>
            <th>HRA</th>
            <th>DA</th>
            <th>Total Salary</th>
        </tr>
        <tr>
            <td><%= eb.getEid() %></td>
            <td><%= eb.getEname() %></td>
            <td><%= eb.getEdesg() %></td>
            <td><%= eb.getEbsal() %></td>
            <td><%= eb.getEhra() %></td>
            <td><%= eb.getEda() %></td>
            <td><%= eb.getEtsal() %></td>
        </tr>
    </table>
<%
} else {
    out.println("<p style='text-align:center;'>Employee session not found. Please log in again.</p>");
}
%>

<div style="text-align:center;">
    <a href="logout"><button>Log Out</button></a>
</div>
</body>
</html>
