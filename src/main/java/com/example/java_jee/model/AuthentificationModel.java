package com.example.java_jee.model;
import java.sql.*;

public class AuthentificationModel {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_residance";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public boolean authenticate(String username, String password) {

        String query, passDb = null;

        int notFound = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = AuthentificationModel.getConnection();
            Statement st = con.createStatement();

            query = "SELECT * FROM admin WHERE nom_utilisateur= '"+username+"'";

            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                passDb = rs.getString("mot_de_passe");
                notFound = 1;
            }
            return notFound == 1 && password.equals(passDb);
        }catch(Exception e){
            System.out.println("Error!" + e.getMessage());
            return false;
        }
    }
}
