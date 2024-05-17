<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/05/2024
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Local Resident</title>
    <!-- Include any CSS stylesheets here -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        form {
            background-color: #ffffff;
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333333;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333333;
        }

        input[type="text"],
        input[type="email"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-right: 10px;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Add New Local Resident</h1>

<form action="AddResiServlet?resi=loc" method="post">
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required><br><br>

    <label for="prenom">Prénom:</label>
    <input type="text" id="prenom" name="prenom" required><br><br>

    <label for="dateDeNaissance">Date de Naissance (YYYY-MM-DD):</label>
    <input type="text" id="dateDeNaissance" name="dateDeNaissance" required><br><br>

    <label for="tel">Téléphone:</label>
    <input type="text" id="tel" name="tel" required><br><br>

    <label for="adresse">Adresse:</label>
    <input type="text" id="adresse" name="adresse" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label>Genre:</label><br>
    <input type="radio" id="male" name="genre" value="M" required>
    <label for="male">Male</label><br>
    <input type="radio" id="female" name="genre" value="F" required>
    <label for="female">Female</label><br><br>

    <label for="dateEntre">Date d'Entrée (YYYY-MM-DD):</label>
    <input type="text" id="dateEntre" name="dateEntre" required><br><br>

    <label for="dateSortie">Date de Sortie (YYYY-MM-DD):</label>
    <input type="text" id="dateSortie" name="dateSortie" required><br><br>

    <label for="etat">État:</label>
    <select id="etat" name="etat" required>
        <option value="Active">Active</option>
        <option value="Inactive">Inactive</option>
    </select><br><br>

    <label for="universite">Université:</label>
    <input type="text" id="universite" name="universite" required><br><br>

    <label for="idChambre">ID Chambre:</label>
    <!-- Replace the options below with dynamic options retrieved from the database -->
    <select id="idChambre" name="idChambre" required>
        <option value="G3E1C1">G3E1C1</option>
        <option value="G3E1C1">G3E1C1</option>
    </select><br><br>

    <label for="telGarant">Téléphone Garant:</label>
    <input type="text" id="telGarant" name="telGarant" required><br><br>

    <label for="programmeDetude">Programme d'Étude:</label>
    <select id="programmeDetude" name="programmeDetude" required>
        <option value="Doctorat">Doctorat</option>
        <option value="Master">Master</option>
        <option value="Licence">Licence</option>
    </select><br><br>

    <label for="reservationNonPayees">Réservations Non Payées:</label>
    <input type="text" id="reservationNonPayees" name="reservationNonPayees" required><br><br>

    <label for="CNE">CNE:</label>
    <input type="text" id="CNE" name="CNE" required><br><br>

    <label for="cin">CIN:</label>
    <input type="text" id="cin" name="cin" required><br><br>

    <input type="submit" value="Save">
    <input type="reset" value="Clear">
</form>
</body>
</html>
