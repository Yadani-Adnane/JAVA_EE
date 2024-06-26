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
    <!-- Added button for adding a new resident -->
    <a href="localResidentForm.jsp">Add New Resident</a>
    <a href="#" class="icon" onclick="toggleNavbar()">
        <!-- Navbar toggle button with icon -->
        Toggle
    </a>
</div>

<div class="container" style="margin-top: 60px;"> <!-- Add margin-top to accommodate navbar -->
    <!-- Header with logo -->
    <div class="header">
        <!-- Removed image -->
        <h1 style="display: inline-block; margin-left: 20px;">Gestion des Résidents Locales</h1>
    </div>

    <!-- Tabbed navigation -->
    <div class="tab">
        <!-- Removed buttons for local and international residents -->
    </div>

    <!-- Local Residents Panel -->
    <div id="localResidents">
        <!-- Add local resident form -->
        <div class="form">

            <form id="localResidentForm">
                <!-- Form fields go here -->
            </form>
        </div>

        <!-- Local residents table -->
        <div class="table">
            <div class="table-container">
                <table >
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
                        <th>CNE</th>
                        <th>CIN</th>
                        <th>Action</th>
                        <!-- Add more table headers as needed -->
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Table body will be populated with data dynamically -->
                        <c:forEach var="resident" items="${rel}">
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
                                <td>${resident.CNE}</td>
                                <td>${resident.cin}</td>
                                <td>
                                    <form action="DeleteResiServlet?resi=loc" method="post" style="display:inline;">
                                        <input type="hidden" name="id" value="${resident.cin}"/>
                                        <input type="submit" value="Supprimer"/>
                                    </form>
                                    <!-- Modify button -->
                                    <a href="UpdateResiServlet?btn=update&resi=loc&nom=${resident.nom}&prenom=${resident.prenom}&dateDeNaissance=${resident.dateDeNaissance}&tel=${resident.tel}&adresse=${resident.adresse}&id=${resident.id}&email=${resident.email}&genre=${resident.genre}&dateEntre=${resident.dateEntre}&dateSortie=${resident.dateSortie}&etet=${resident.etat}&universite=${resident.universite}&idChambre=${resident.idChambre}&telGarant=${resident.telGarant}&programmeDetude=${resident.programmeDetude}&reservationNonPayees=${resident.reservationNonPayees}&cne=${resident.CNE}&cin=${resident.cin}">
                                        <button >Modify</button>
                                    </a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>

</div>



</body>
</html>

