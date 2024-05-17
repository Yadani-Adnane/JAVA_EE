<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/05/2024
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Résidents</title>
    <!-- Include CSS styles -->
    <link rel="stylesheet" type="text/css" href="gestionR.css">
    <style>
        /* Add custom CSS for navbar toggle */
        .navbar {
            overflow: hidden;
            background-color: #006666; /* Blue color */
            position: fixed;
            top: 0;
            width: 100%;
        }

        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .navbar a.active {
            background-color: #04AA6D;
            color: white;
        }

        .navbar .icon {
            display: none;
        }

        @media screen and (max-width: 600px) {
            .navbar a:not(:first-child) {display: none;}
            .navbar a.icon {
                float: right;
                display: block;
            }
        }

        @media screen and (max-width: 600px) {
            .navbar.responsive {position: relative;}
            .navbar.responsive .icon {
                position: absolute;
                right: 0;
                top: 0;
            }
            .navbar.responsive a {
                float: none;
                display: block;
                text-align: left;
            }
        }
    </style>
</head>
<body>
<div  class="navbar" id="myNavbar">
    <a href="homePage.jsp" class="active">Home</a>
    <!-- Added buttons for local and international residents -->
    <!-- Added button for adding a new resident -->
    <a href="interResidentForm.jsp">Add New Resident</a>
    <a href="#" class="icon" onclick="toggleNavbar()">
        <!-- Navbar toggle button with icon -->
        Toggle
    </a>
</div>

<div class="container" style="margin-top: 60px;"> <!-- Add margin-top to accommodate navbar -->
    <!-- Header with logo -->
    <div class="header">
        <!-- Removed image -->
        <h1 style="display: inline-block; margin-left: 20px;">Gestion des Résidents International</h1>
    </div>

    <!-- Tabbed navigation -->
    <div class="tab">
        <!-- Removed buttons for local and international residents -->
    </div>


    <!-- International Residents Panel -->
    <div id="internationalResidents">
        <!-- Add international resident form -->
        <div class="form">

            <form id="internationalResidentForm">
                <!-- Form fields go here -->
            </form>
        </div>

        <!-- International residents table -->
        <div class="table">

            <table id="internationalResidentsTable">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date de Naissance</th>
                    <th>Téléphone</th>
                    <th>Adresse</th>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Genre</th>
                    <th>Date d'Entrée</th>
                    <th>Date de Sortie</th>
                    <th>État</th>
                    <th>Université</th>
                    <th>ID Chambre</th>
                    <th>Téléphone Garant</th>
                    <th>Programme d'Étude</th>
                    <th>Réservations Non Payées</th>
                    <th>Numéro de Passport</th>
                    <th>Pays</th>
                    <th>Action</th>
                    <!-- Add more table headers as needed -->
                </tr>
                </thead>
                <tbody>

                        <c:forEach var="resident" items="${re}">
                            <tr>
                                <td>${resident.nom}</td>
                                <td>${resident.prenom}</td>
                                <td>${resident.dateDeNaissance}</td>
                                <td>${resident.tel}</td>
                                <td>${resident.adresse}</td>
                                <td>${resident.id}</td>
                                <td>${resident.email}</td>
                                <td>${resident.genre}</td>
                                <td>${resident.dateEntre}</td>
                                <td>${resident.dateSortie}</td>
                                <td>${resident.etat}</td>
                                <td>${resident.universite}</td>
                                <td>${resident.idChambre}</td>
                                <td>${resident.telGarant}</td>
                                <td>${resident.programmeDetude}</td>
                                <td>${resident.reservationNonPayees}</td>
                                <td>${resident.numPassport}</td>
                                <td>${resident.pays}</td>
                                <td>
                                    <button onclick="deleteResident(this)">Delete</button>
                                    <!-- Modify button -->
                                    <button onclick="modifyResident(this)">Modify</button>
                                </td>
                            </tr>
                        </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Include JavaScript for tab functionality -->

</body>
</html>
