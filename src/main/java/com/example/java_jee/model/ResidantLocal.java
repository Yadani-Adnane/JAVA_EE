package com.example.java_jee.model;



import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResidantLocal extends Residant{
	
	public ResidantLocal() {
		super();
	}
	private String CNE;
    private String cin;
    

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
	
	@Override
    public void creer() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super.creer(); 
        // Establish database connection (Assuming you have a Connection object named 'connection')
        try(Connection connection = AuthentificationModel.getConnection()) {
            // Prepare SQL statement
            String sql = "INSERT INTO ResidantLocal (id, cne, cin) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameters
            statement.setString(1, getId());
            statement.setString(2, CNE);
            statement.setString(3, cin);
            System.out.println(statement);
            // Execute the INSERT statement
            statement.executeUpdate();

            // Close the statement
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static List<ResidantLocal> getLocalResidents() {
        List<ResidantLocal> localResidents = new ArrayList<>();

        try (Connection connection =AuthentificationModel.getConnection()) {
            // Prepare SQL query
            String sql = "SELECT p.nom, p.prenom, p.naissance, p.tel, p.adresse, p.id_personne, p.mail, p.genre, " +
                    "p.date_entree, p.date_sortie, r.etat, r.universite, r.id_chambre, r.telgarant, r.programmeDetudes, " +
                    "r.reservationNonPayees, rl.CNE, rl.cin " +
                    "FROM Personne p " +
                    "JOIN Residant r ON p.id_personne = r.id_residant " +
                    "JOIN ResidantLocal rl ON r.id_residant = rl.id";

            // Create and execute statement
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                // Get data from the result set
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

                // Create ResidantLocal instance and add to the list
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
	@Override
	public void supprimer(String id) {
	    super.supprimer(id);
	    // Additional logic to delete the record from the ResidantLocal table
	    try (Connection connection = AuthentificationModel.getConnection()) {
	        String deleteQuery = "DELETE FROM ResidantLocal WHERE id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setString(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	@Override
	public void modifier(String id) {
	    super.modifier(id); 
	    try (Connection connection = AuthentificationModel.getConnection()) {
	        String updateQuery = "UPDATE ResidantLocal SET cne=?, cin=? WHERE id=?";
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, CNE);
	        preparedStatement.setString(2, cin);
	        preparedStatement.setString(3, getId());
	        preparedStatement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}


    @Override
    public String toString() {
        return "ResidantLocal{" +
                "cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDeNaissance='" + dateDeNaissance + '\'' +
                ", tel='" + tel + '\'' +
                ", adresse='" + adresse + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", genre='" + genre + '\'' +
                ", dateEntre='" + dateEntre + '\'' +
                ", CNE='" + CNE + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                '}';
    }
}


