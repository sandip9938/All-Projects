<%@page import="com.sp.bean.UserBean"%>
<%@page import="com.sp.service.EditProfileServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.sp.bean.UserBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style>
    /* Light Mode Colors */
    :root {
        --background-color: #ffffff;
        --text-color: #000000;
        --input-bg: #f0f0f0;
        --input-text: #000000;
        --link-color: #007BFF;
        --button-bg: #007BFF;
        --button-text: #ffffff;
    }

    /* Dark Mode Colors */
    .dark-mode {
        --background-color: #121212;
        --text-color: #ffffff;
        --input-bg: #333333;
        --input-text: #ffffff;
        --link-color: #BB86FC;
        --button-bg: #6200ea;
        --button-text: #ffffff;
    }

    /* General Styles */
    body {
        background-color: var(--background-color);
        color: var(--text-color);
        font-family: Arial, sans-serif;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 20px;
        transition: background-color 0.3s, color 0.3s;
    }

    p {
        font-size: 18px;
    }

    a {
        color: var(--link-color);
        text-decoration: none;
        font-weight: bold;
        margin: 10px;
        transition: color 0.3s;
    }

    a:hover {
        text-decoration: underline;
    }

    /* Table Styles */
    table {
        width: 80%;
        margin-top: 20px;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid var(--text-color);
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: var(--button-bg);
        color: var(--button-text);
    }

    td {
        background-color: var(--input-bg);
    }

    /* Toggle Button Styles */
    .mode-switch {
        position: absolute;
        top: 10px;
        right: 10px;
        padding: 8px 12px;
        background-color: var(--button-bg);
        color: var(--button-text);
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
        transition: background-color 0.3s, color 0.3s;
    }

</style>
</head>
<body>

    <!-- Dark/Light Mode Toggle Button -->
    <button class="mode-switch" onclick="toggleMode()">Switch Mode</button>

    <%
        UserBean ub = (UserBean) application.getAttribute("ubean");
        out.println("Welcome User: " + ub.getUfn() + "<br>");
    %>

    <!-- Table to display user profile information -->
    <table>
        <tr>
            <th>User ID</th>
            <td><%= ub.getUserid() %></td>
        </tr>
        <tr>
            <th>First Name</th>
            <td><%= ub.getUfn() %></td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td><%= ub.getUln() %></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><%= ub.getUad() %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= ub.getUmid() %></td>
        </tr>
        <tr>
            <th>Phone Number</th>
            <td><%= ub.getUno() %></td>
        </tr>
    </table>

    <br>
    <a href="edit">Edit Profile</a>
    <br>
    <a href="logout">Logout</a>

<script>
    // Check for saved mode preference
    const currentMode = localStorage.getItem('color-mode');
    if (currentMode === 'dark') {
        document.body.classList.add('dark-mode');
    }

    // Toggle between dark and light mode
    function toggleMode() {
        document.body.classList.toggle('dark-mode');
        const mode = document.body.classList.contains('dark-mode') ? 'dark' : 'light';
        localStorage.setItem('color-mode', mode);
    }
</script>

</body>
</html>
