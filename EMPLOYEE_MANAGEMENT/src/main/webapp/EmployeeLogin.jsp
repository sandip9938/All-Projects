<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.sp.bean.EmployeeBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #434343, #000000);
            color: rgb(240, 238, 234);
            font-family: 'Roboto', sans-serif;
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
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.3s;
        }

        button:hover {
            background-color: rgb(182, 182, 223);
            color: #212121;
            transform: scale(1.05);
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
            background-color: #4f4f4f;
        }

        tr:hover {
            background-color: rgba(182, 182, 223, 0.2);
        }

        @media (max-width: 600px) {
            button {
                width: 100%;
                font-size: 16px;
            }

            th, td {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<%
    // Retrieve the EmployeeBean from the session
    EmployeeBean eb = (EmployeeBean) session.getAttribute("ebean");

    // Check if the EmployeeBean object is present
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
        // If EmployeeBean is not found, display a message
        out.println("<p style='text-align:center;'>Employee session not found. Please log in again.</p>");
    }
%>

<div style="text-align:center;">
    <!-- Proper logout link to invalidate the session -->
    <a href="<%= request.getContextPath() %>/logout"><button>Log Out</button></a>
</div>

</body>
</html>
