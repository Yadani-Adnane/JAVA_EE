package com.example.java_jee.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Personne {
    

	public Personne() {
		
	}
	protected String nom;
    protected String prenom;
    protected String dateDeNaissance;
    protected String tel;
    protected String adresse;
    protected String id;
    protected String email;
    protected String genre;
    protected String dateEntre;
    protected String dateSortie;
    public Personne(String nom, String prenom, String dateDeNaissance, String tel, String adresse, String id,
			String email, String genre, String dateEntre, String dateSortie) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.tel = tel;
		this.adresse = adresse;
		this.id = id;
		this.email = email;
		this.genre = genre;
		this.dateEntre = dateEntre;
		this.dateSortie = dateSortie;
	}

   
    public  void supprimer(String id) {
        // Define SQL query to delete a person based on their ID
        String deleteQuery = "DELETE FROM personne WHERE id_personne = ?";

        // Try-with-resources to automatically close resources
        try (Connection connection = AuthentificationModel.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            // Set ID parameter in the prepared statement
            preparedStatement.setString(1, id);

            // Execute the deletion query
            int rowsDeleted = preparedStatement.executeUpdate();

            // Check if any rows were affected by the deletion
            if (rowsDeleted > 0) {
                System.out.println("Person with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No person found with ID " + id + ".");
            }

        } catch (SQLException ex) {
            System.out.println("Error deleting person with ID " + id + ": " + ex.getMessage());
        }
    }


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDateEntre() {
		return dateEntre;
	}

	public void setDateEntre(String dateEntre) {
		this.dateEntre = dateEntre;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}
	public void creer() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Establish database connection (Assuming you have a Connection object named 'connection')
		
		try(Connection connection =AuthentificationModel.getConnection()) {
            // Prepare SQL statement
            String sql = "INSERT INTO Personne (nom, prenom, naissance, tel, adresse, id_personne, mail, genre, date_entree, date_sortie) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Set parameters
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, dateDeNaissance);
            statement.setString(4, tel);
            statement.setString(5, adresse);
            statement.setString(6, id);
            statement.setString(7, email);
            statement.setString(8, genre);
            statement.setString(9, dateEntre);
            statement.setString(10, dateSortie);
			System.out.println(statement);
            // Execute the INSERT statement
            statement.executeUpdate();
            
            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public void modifier(String id) {
	    // Define SQL query to update resident information
	    String updateQuery = "UPDATE personne SET nom=?, prenom=?, naissance=?, tel=?, adresse=?, mail=?, genre=?, date_entree=?, date_sortie=? WHERE id_personne=?";
	    
	    try (Connection connection = AuthentificationModel.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	        
	        // Set parameters for the update query
	        preparedStatement.setString(1, nom);
	        preparedStatement.setString(2, prenom);
	        preparedStatement.setString(3, dateDeNaissance);
	        preparedStatement.setString(4, tel);
	        preparedStatement.setString(5, adresse);
	        preparedStatement.setString(6, email);
	        preparedStatement.setString(7, genre);
	        preparedStatement.setString(8, dateEntre);
	        preparedStatement.setString(9, dateSortie);
	        preparedStatement.setString(10, id);
	        
	        // Execute the update query
	        int rowsUpdated = preparedStatement.executeUpdate();
	        
	        // Check if any rows were updated
	        if (rowsUpdated > 0) {
	            System.out.println("Resident with ID " + id + " updated successfully.");
	        } else {
	            System.out.println("No resident found with ID " + id + ".");
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error updating resident with ID " + id + ": " + ex.getMessage());
	    }
	}


}
	

