package com.example.java_jee.model;



import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResidantEtranger extends Residant {
    
	
	public ResidantEtranger() {
		super();
	}
	private String numPassport;
    private String pays;
    public ResidantEtranger(String nom, String prenom, String dateDeNaissance, String tel, String adresse, String id,
            String email, String genre, String dateEntre, String dateSortie, String etat, String universite,
            String idChambre, String telGarant, String programmeDetude, int reservationNonPayees,
            String numPassport, String pays) {
		super(nom, prenom, dateDeNaissance, tel, adresse, id, email, genre, dateEntre, dateSortie, etat, universite,
		idChambre, telGarant, programmeDetude, reservationNonPayees);
		this.numPassport = numPassport;
		this.pays = pays;
}
	public String getNumPassport() {
		return numPassport;
	}
	
	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
    public void creer() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super.creer(); 
        // Establish database connection (Assuming you have a Connection object named 'connection')
        try(Connection connection =AuthentificationModel.getConnection()) {
            // Prepare SQL statement
            String sql = "INSERT INTO ResidantEtranger (id, numPassport, pays) " +
                    "VALUES (?, ?, ?)";
            
			PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameters
            statement.setString(1, getId());
            statement.setString(2, numPassport);
            statement.setString(3, pays);

            // Execute the INSERT statement
            statement.executeUpdate();

            // Close the statement
            statement.close();

			String sql1 = "INSERT INTO reservation (date_reservation,id_residant,id_chambre,payee,recu,frais_de_reservation )"+
					"VALUES ( ?, ?, ?, '0', '', 600)";
			LocalDate todaysDate = LocalDate.now();
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, todaysDate.toString() );
			statement1.setString(2, getId() );
			statement1.setString(3, getIdChambre());
			// Execute the INSERT statement
			statement1.executeUpdate();

			// Close the statem
			statement1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static  List<ResidantEtranger> getInternationalResidents() {
        List<ResidantEtranger> internationalResidents = new ArrayList<>();
        try (Connection connection =AuthentificationModel.getConnection()) {
            String sql = "SELECT p.nom, p.prenom, p.naissance, p.tel, p.adresse, p.id_personne, p.mail, p.genre, " +
                    "p.date_entree, p.date_sortie, r.etat, r.universite, r.id_chambre, r.telgarant, r.programmeDetudes, " +
                    "r.reservationNonPayees, rI.numPassport, rI.pays " +
                    "FROM Personne p " +
                    "JOIN Residant r ON p.id_personne = r.id_residant " +
                    "JOIN ResidantEtranger rI ON r.id_residant = rI.id";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
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
                        String numPassport = resultSet.getString("numPassport");
                        String pays = resultSet.getString("pays");
               
                
                ResidantEtranger residantEtranger = new ResidantEtranger(nom, prenom, dateDeNaissance, tel, adresse, id, email,
                        genre, dateEntre, dateSortie, etat, universite, idChambre, telGarant, programmeDetude,
                        reservationNonPayees, numPassport, pays);
                internationalResidents.add(residantEtranger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internationalResidents;
    }
	@Override
	public void supprimer(String id) {
	    super.supprimer(id);
	    try (Connection connection = AuthentificationModel.getConnection()) {
	        String deleteQuery = "DELETE FROM ResidantEtranger WHERE id = ?";
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
	        String updateQuery = "UPDATE ResidantEtranger SET numPassport=?, pays=? WHERE id=?";
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, numPassport);
	        preparedStatement.setString(2, pays);
	        preparedStatement.setString(3, getId());
	        preparedStatement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	

}