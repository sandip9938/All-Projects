<%@page import="com.sp.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Update Employee</title>
    <style>
        body {
            background-color: #352f2f;
            color: rgb(240, 238, 234);
            font-family: Georgia, 'Times New Roman', Times, serif;
            font-weight: 400;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center; /* Center the content */
        }

        h2 {
            margin-bottom: 20px; /* Space below the title */
        }

        button {
            justify-content: center;
            margin: 10px;
            cursor: pointer;
            font-family: 'Times New Roman', Times, serif;
            background-color: #212121;
            letter-spacing: 0.2px;
            color: antiquewhite;
            border: 2px solid rgb(182, 182, 223);
            padding: 10px 20px; /* Increased padding for a better touch target */
            border-radius: 5px; /* Rounded corners for buttons */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
        }

        button:hover {
            background-color: rgb(182, 182, 223); /* Change background on hover */
            color: #212121; /* Dark text on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        .message {
            margin: 20px 0; /* Space around messages */
            font-size: 16px; /* Font size for messages */
        }
    </style>
</head>
<body>
<%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    String msg = (String) request.getAttribute("msg");

    if (ab != null) {
%>
        <h2>Page belongs to Admin: <%= ab.getFname() %></h2>
<%
    } else {
        out.println("<p class='message'>Admin information is not available.</p>");
    }
    
    if (msg != null && !msg.isEmpty()) {
%>
        <p class='message'><%= msg %></p>
<%
    }
%>
    <a href="employeeadd.html"><button>Add Employee</button></a>
    <a href="view"><button>View All Employees</button></a>
    <a href="logout"><button>Log Out</button></a>
</body>
</html>
