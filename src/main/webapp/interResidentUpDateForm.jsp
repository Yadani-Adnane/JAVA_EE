<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/05/2024
  Time: 17:36
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

<form action="UpdateResiServlet?btn=save&resi=et&id=${param.id}" method="post">
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" value="${param.nom}" required><br><br>

    <label for="prenom">Prénom:</label>
    <input type="text" id="prenom" name="prenom" value="${param.prenom}" required><br><br>

    <label for="dateDeNaissance">Date de Naissance (YYYY-MM-DD):</label>
    <input type="text" id="dateDeNaissance" name="dateDeNaissance" value="${param.dateDeNaissance}" required><br><br>

    <label for="tel">Téléphone:</label>
    <input type="text" id="tel" name="tel" value="${param.tel}" required><br><br>

    <label for="adresse">Adresse:</label>
    <input type="text" id="adresse" name="adresse" value="${param.adresse}" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${param.email}" required><br><br>

    <label>Genre:</label><br>
    <input type="radio" id="male" name="genre" value="M" ${param.genre == 'M' ? 'checked' : ''} required>
    <label for="male">Male</label><br>
    <input type="radio" id="female" name="genre" value="F" ${param.genre == 'F' ? 'checked' : ''} required>
    <label for="female">Female</label><br><br>

    <label for="dateEntre">Date d'Entrée (YYYY-MM-DD):</label>
    <input type="text" id="dateEntre" name="dateEntre" value="${param.dateEntre}" required><br><br>

    <label for="dateSortie">Date de Sortie (YYYY-MM-DD):</label>
    <input type="text" id="dateSortie" name="dateSortie" value="${param.dateSortie}" required><br><br>

    <label for="etat">État:</label>
    <select id="etat" name="etat" required>
        <option value="Active" ${param.etat == 'Active' ? 'selected' : ''}>Active</option>
        <option value="Inactive" ${param.etat == 'Inactive' ? 'selected' : ''}>Inactive</option>
    </select><br><br>

    <label for="universite">Université:</label>
    <input type="text" id="universite" value="${param.universite}" name="universite" required><br><br>

    <label for="idChambre">ID Chambre:</label>
    <!-- Replace the options below with dynamic options retrieved from the database -->
    <select id="idChambre" name="idChambre" required>
        <option value="G3E1C1" ${param.idChambre == 'G3E1C1' ? 'selected' : ''}> G3E1C1</option>
        <option value="G3E1C2" ${param.idChambre == 'G3E1C2' ? 'selected' : ''}>G3E1C2</option>
    </select><br><br>

    <label for="telGarant">Téléphone Garant:</label>
    <input type="text" id="telGarant" name="telGarant" value="${param.telGarant}" required><br><br>

    <label for="programmeDetude">Programme d'Étude:</label>
    <select id="programmeDetude" name="programmeDetude" required>
        <option value="Doctorat" ${param.programmeDetude == 'Doctorat' ? 'selected' : ''}>Doctorat</option>
        <option value="Master" ${param.programmeDetude == 'Master' ? 'selected' : ''}>Master</option>
        <option value="Licence" ${param.programmeDetude == 'Licence' ? 'selected' : ''}>Licence</option>
    </select><br><br>

    <label for="reservationNonPayees">Réservations Non Payées:</label>
    <input type="text" id="reservationNonPayees" name="reservationNonPayees" value="${param.reservationNonPayees}" required><br><br>

    <label for="numPassport">Numéro de Passport:</label>
    <input type="text" id="numPassport" name="numPassport" value="${param.numPassport}" required><br><br>

    <label for="pays">Pays:</label>
    <input type="text" id="pays" name="pays" value="${param.pays}"  required><br><br>

    <input type="submit" value="Save">
    <input type="reset" value="Clear">
</form>
</body>
</html>
