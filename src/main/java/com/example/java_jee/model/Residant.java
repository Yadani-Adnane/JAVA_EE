package com.example.java_jee.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Residant extends Personne{
	
	public Residant() {
		super();
	}
	private String etat;
    private String universite;
    private String idChambre;
    private String telGarant;
    private String programmeDetude;
    private int reservationNonPayees;
    
    public Residant(String nom, String prenom, String dateDeNaissance, String tel, String adresse, String id,
			String email, String genre, String dateEntre, String dateSortie, String etat, String universite,
			String idChambre, String telGarant, String programmeDetude, int reservationNonPayees) {
		super(nom, prenom, dateDeNaissance, tel, adresse, id, email, genre, dateEntre, dateSortie);
		this.etat = etat;
		this.universite = universite;
		this.idChambre = idChambre;
		this.telGarant = telGarant;
		this.programmeDetude = programmeDetude;
		this.reservationNonPayees = reservationNonPayees;
	}

    
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(String idChambre) {
		this.idChambre = idChambre;
	}

	public String getTelGarant() {
		return telGarant;
	}

	public void setTelGarant(String telGarant) {
		this.telGarant = telGarant;
	}

	public String getProgrammeDetude() {
		return programmeDetude;
	}

	public void setProgrammeDetude(String programmeDetude) {
		this.programmeDetude = programmeDetude;
	}

	public int getReservationNonPayees() {
		return reservationNonPayees;
	}

	public void setReservationNonPayees(int reservationNonPayees) {
		this.reservationNonPayees = reservationNonPayees;
	}
	@Override
    public void creer() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super.creer(); 
        
        try(Connection connection = AuthentificationModel.getConnection()) {
            String sql = "INSERT INTO Residant (id_residant,id_chambre,telgarant,etat,universite,programmeDetudes) " +
                         "VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, id);
            statement.setString(2, idChambre);
            statement.setString(3, telGarant);
            statement.setString(4, etat);
            statement.setString(5, universite);
            statement.setString(6, programmeDetude);
            
            // Execute the INSERT statement
            statement.executeUpdate();
            
            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void supprimer(String id) {
	    super.supprimer(id);
	    // Additional logic to delete the record from the Residant table
	    try (Connection connection = AuthentificationModel.getConnection()) {
	        String deleteQuery = "DELETE FROM Residant WHERE id_residant = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setString(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	@Override
	public void modifier(String id_residant) {
	    super.modifier(id_residant); // Call the modifier method of the superclass (Personne)
	    // Additional logic to update the record in the Residant table
	    try (Connection connection = AuthentificationModel.getConnection()) {
	        String updateQuery = "UPDATE Residant SET id_chambre=?, telgarant=?, etat=?, universite=?,programmeDetudes=? WHERE id_residant=?";
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, idChambre);
	        preparedStatement.setString(2, telGarant);
	        preparedStatement.setString(3, etat);
	        preparedStatement.setString(4, universite);

	        preparedStatement.setString(5, programmeDetude);
	        preparedStatement.setString(6, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}


	
}