<%@page import="java.util.ArrayList"%>
<%@page import="com.sp.bean.EmployeeBean"%>
<%@page import="com.sp.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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

        table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px 0;
        }

        th, td {
            border: 2px solid white;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #444;
        }

        tr:nth-child(even) {
            background-color: #555;
        }

        tr:hover {
            background-color: #666; /* Highlight row on hover */
        }

        button {
            margin: 10px;
            cursor: pointer;
            background-color: #212121;
            color: antiquewhite;
            border: 2px solid rgb(182, 182, 223);
            padding: 10px 20px; /* Better padding */
            font-size: 18px; /* Font size for button */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
        }

        button:hover {
            background-color: rgb(182, 182, 223); /* Lighten on hover */
            color: #212121; /* Dark text on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        @media (max-width: 600px) {
            table {
                font-size: 14px; /* Adjust font size for smaller screens */
            }

            button {
                width: 100%; /* Full width buttons on small screens */
            }
        }
    </style>
</head>
<body>
<%
AdminBean ab = (AdminBean) session.getAttribute("abean");
ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)session.getAttribute("alist");
if (ab == null) {
    out.println("<p>Admin session not found.</p>");
} else {
    out.println("<h2>Welcome Admin: " + ab.getFname() + "</h2>");
    if (al == null || al.isEmpty()) {
        out.println("<p>No Employees Available.</p>");
    } else {
%>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Basic Salary</th>
                <th>HRA</th>
                <th>DA</th>
                <th>Total Salary</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (EmployeeBean eb : al) { %>
            <tr>
                <td><%= eb.getEid() %></td>
                <td><%= eb.getEname() %></td>
                <td><%= eb.getEdesg() %></td>
                <td><%= eb.getEbsal() %></td>
                <td><%= eb.getEhra() %></td>
                <td><%= eb.getEda() %></td>
                <td><%= eb.getEtsal() %></td>
                <td>
                    <a href="edits?eid=<%= eb.getEid() %>" style="color: lightblue;">Edit</a> |
                    <a href="delete?eid=<%= eb.getEid() %>" style="color: lightcoral;">Delete</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
<%
    }
}
%>
    <a href="employeeadd.html"><button>Add Employee</button></a>
    <a href="logout"><button>Log Out</button></a>
</body>
</html>

