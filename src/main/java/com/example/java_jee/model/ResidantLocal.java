package com.example.java_jee.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidantLocal extends Residant {

    private String CNE;
    private String cin;

    public ResidantLocal() {
        super();
    }

    public ResidantLocal(String nom, String prenom, String dateDeNaissance, String tel, String adresse, String id,
                         String email, String genre, String dateEntre, String dateSortie, String etat, String universite,
                         String idChambre, String telGarant, String programmeDetude, int reservationNonPayees,
                         String CNE, String cin) {
        super(nom, prenom, dateDeNaissance, tel, adresse, id, email, genre, dateEntre, dateSortie, etat, universite,
                idChambre, telGarant, programmeDetude, reservationNonPayees);
        this.CNE = CNE;
        this.cin = cin;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String cNE) {
        CNE = cNE;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public static List<ResidantLocal> getLocalResidents() {
        List<ResidantLocal> localResidents = new ArrayList<>();

        try (Connection connection = AuthentificationModel.getConnection()) {
            String sql = "SELECT p.nom, p.prenom, p.naissance, p.tel, p.adresse, p.id_personne, p.mail, p.genre, " +
                    "p.date_entree, p.date_sortie, r.etat, r.universite, r.id_chambre, r.telgarant, r.programmeDetudes, " +
                    "r.reservationNonPayees, rl.CNE, rl.cin " +
                    "FROM Personne p " +
                    "JOIN Residant r ON p.id_personne = r.id_residant " +
                    "JOIN ResidantLocal rl ON r.id_residant = rl.id";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String dateDeNaissance = resultSet.getString("naissance");
                String tel = resultSet.getString("tel");
                String adresse = resultSet.getString("adresse");
                String id = resultSet.getString("id_personne");
                String email = resultSet.getString("mail");
                String genre = resultSet.getString("genre");
                String dateEntre = resultSet.getString("date_entree");
                String dateSortie = resultSet.getString("date_sortie");
                String etat = resultSet.getString("etat");
                String universite = resultSet.getString("universite");
                String idChambre = resultSet.getString("id_chambre");
                String telGarant = resultSet.getString("telgarant");
                String programmeDetude = resultSet.getString("programmeDetudes");
                int reservationNonPayees = resultSet.getInt("reservationNonPayees");
                String CNE = resultSet.getString("CNE");
                String cin = resultSet.getString("cin");

                ResidantLocal residantLocal = new ResidantLocal(nom, prenom, dateDeNaissance, tel, adresse, id, email,
                        genre, dateEntre, dateSortie, etat, universite, idChambre, telGarant, programmeDetude,
                        reservationNonPayees, CNE, cin);
                localResidents.add(residantLocal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localResidents;
    }

}

