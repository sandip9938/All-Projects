<%@page import="com.sp.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.sp.bean.UserBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>
    /* Light Mode Colors */
    :root {
        --background-color: #ffffff;
        --text-color: #000000;
        --link-color: #007BFF;
        --button-bg: #007BFF;
        --button-text: #ffffff;
    }

    /* Dark Mode Colors */
    .dark-mode {
        --background-color: #121212;
        --text-color: #ffffff;
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

    <a href="view">View Profile</a>
    <br>
    <a href="logout">Logout</a>
    <br>

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


