<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/05/2024
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Home Page</title>
  <link rel="stylesheet" type="text/css" href="home-styles.css"> <!-- Link to your external CSS file -->
  <style>
    /* Add custom CSS for dropdown menu */
    .dropdown {
      position: relative;
      display: inline-block;
    }

    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #006666;
      min-width: 160px;
      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
      z-index: 1;
    }

    .dropdown-content a {
      color: black;
      padding: 12px 16px;
      text-decoration: none;
      display: block;
    }

    .dropdown-content a:hover {
      background-color: #ddd;
    }

    .dropdown:hover .dropdown-content {
      display: block;
    }
  </style>
</head>
<body>
<div class="container">
  <!-- Left Frame -->
  <div class="left-frame">
    <div class="logo-container">
      <img src="logo.png" alt="Logo" class="logo">
    </div>
    <div class="dropdown">
      <button class="form-submit">Gestion des Résidents</button>
      <div class="dropdown-content">
        <a href="GestionResidantLocalServlet">Gestion des résidents locaux</a>
        <a href="GestionResidantInternationaleServlet">Gestion des résidents internationaux</a>
      </div>
    </div>
  </div>
  <!-- Right Frame -->
  <div class="right-frame">
    <!-- Dashboard content goes here -->
  </div>
</div>
</body>
</html>
