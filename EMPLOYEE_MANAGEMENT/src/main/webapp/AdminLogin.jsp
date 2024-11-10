<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.sp.bean.AdminBean"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #434343, #000000); /* Gradient background */
            color: rgb(240, 238, 234);
            font-family: 'Roboto', sans-serif; /* Modern font */
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            margin-bottom: 30px;
        }

        button {
            margin: 10px;
            cursor: pointer;
            background-color: #212121;
            color: antiquewhite;
            border: 2px solid rgb(182, 182, 223);
            padding: 10px 20px; /* Improved padding */
            font-size: 18px; /* Font size for button */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
        }

        button:hover {
            background-color: rgb(182, 182, 223); /* Lighten on hover */
            color: #212121; /* Dark text on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        .welcome-message {
            text-align: center; /* Center the welcome message */
            margin-bottom: 30px;
        }

        @media (max-width: 600px) {
            button {
                width: 100%; /* Full width buttons on small screens */
            }
        }
    </style>
</head>
<body>
<%
    AdminBean abBean = (AdminBean) session.getAttribute("abean");
    if (abBean != null) {
%>
        <h1>Welcome Admin: <%= abBean.getFname() %></h1>
<%
    } else {
%>
        <h1>Admin information not available.</h1>
<%
    }
%>
    <a href="employeeadd.html"><button>Add Employee</button></a> 
    <a href="view"><button>View All Employees</button></a>
    <a href="logout"><button>Log Out</button></a>
</body>
</html>

