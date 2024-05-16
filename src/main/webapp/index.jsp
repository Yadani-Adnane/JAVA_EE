<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet , java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentication</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="left-frame">
        <img src="logo.png" alt="Logo" class="logo">
    </div>
    <div class="right-frame">
        <div class="form-container">
            <h1>LOGIN</h1>
            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label class="form-label" for="username">Username:</label>
                    <input type="text" class="form-input" id="username" name="username">
                </div>
                <div class="form-group">
                    <label class="form-label" for="password">Password:</label>
                    <input type="password" class="form-input" id="password" name="password">
                </div>
                <div class="form-group">
                    <input type="checkbox" id="show-password">
                    <label class="form-label" for="show-password">Show Password</label>
                </div>
                <div class="button-group">
                    <input type="submit" class="form-submit" value="Login">
                    <input type="button" class="form-clear" value="Clear">
                </div>
            </form>
            <div class="error-message">
                <% if (request.getAttribute("error") != null) { %>
                <%= request.getAttribute("error") %>
                <% } %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
