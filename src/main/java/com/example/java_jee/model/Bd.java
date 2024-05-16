package com.example.java_jee.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// la classse BD permet la gestion de la communication avec la base de données
public class Bd {

    // declaration des paramètres de connexion
    private String Url, User, Pass, DbName;
    private Statement st;
    private ResultSet rs;
    private Connection con;

    // initialisation des paramètres de connexion avec des valeurs par défaut
    public Bd() {
        Url = "jdbc:MySQL://localhost:3306/bd_residance";
        User = "root";
        Pass = "";
    }

    // initialisation des paramètres de connexion avec des valeurs choisies
    public Bd(String User, String Pass, String DbName) {
        this.User = User;
        this.Pass = Pass;
        this.DbName = DbName;
        Url="jdbc:mysql://localhost:3306/"+DbName;
    }

    // etablissement de la connecxion
    public boolean connect(){
        boolean b = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url, User, Pass);
            st = con.createStatement();
            b=true;
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
            b=false;
        }
        return b;
    }

    public double selectFun(String fun,String table,String col,String condition)  {
        if(connect()){
            String query = "SELECT "+fun+"("+col+") as fun"+" FROM " + table.toLowerCase() + " WHERE " + condition;
            System.out.println(query);
            try {
                rs = st.executeQuery(query);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(rs.next()){
                    System.out.println(rs.getString("fun"));
                    return rs.getInt("fun");
                }else return -1;


            } catch (SQLException e) {
                 System.out.println(new RuntimeException(e).getMessage());
                return -1;
            }

        }else return -1;
    }
    // methode de selection de données
    public  List<Object> select(String clonnes, String table, String condition) throws ClassNotFoundException, NoSuchMethodException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classe = Class.forName("com.example.residance.model."+table); // 1

        if (connect()){
            List<Object> donnees = new ArrayList<>(); // conteneurs des données
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, table, null);
            List<Class<?>> types = new ArrayList<>(); // conteneurs des types des colonnes
            List<String> cols = new ArrayList<>(); // conteneurs des noms des colonnes
            while (resultSet.next()) {
                String typeColonne = resultSet.getString("TYPE_NAME"); // récupération des types des colonnes
                String nomCol = resultSet.getString("COLUMN_NAME"); // récupération des nom des colonnes
                Class<?> type = convertirTypeSQLenTypeJava(typeColonne); // voir le corps de la methode en bas
                types.add(type);
                cols.add(nomCol);
            }
            Class<?>[] typesArray = types.toArray(new Class<?>[0]);

            Constructor<?> constructor = classe.getDeclaredConstructor(typesArray); // 2  (1 et 2) création d'une réferance de la classe appartir de nom notre table
            boolean b = false;
            String query = "SELECT "+clonnes+" FROM " + table.toLowerCase() + " WHERE " + condition;
            try {
                rs = st.executeQuery(query);
                while(rs.next()){ // récupération des valeurs des colonnes
                    ArrayList list = new ArrayList();
                    for (int i = 0; i < cols.size(); i++) {
                        if(types.get(i).equals(String.class)){
                            list.add(rs.getString(cols.get(i)));
                        } else {
                            if (types.get(i).equals(Date.class)){
                                list.add(rs.getDate(cols.get(i)));
                            }else if (types.get(i).equals(float.class)){
                                list.add(rs.getFloat(cols.get(i)));
                            }else {
                                list.add(rs.getInt(cols.get(i)));
                            }
                        }
                    }
                    Object ob = constructor.newInstance(list.toArray()); // création d'une instance de la classe de notre table
                    donnees.add(ob); // regrouper les données dans le conteneur
                }


            } catch (Exception e) {
                System.out.println("Error!" + e.getMessage());
                return null;
            }
            return donnees;
        }else {
            return null;
        }
    }

    // méthode d'insertion des données
    public boolean insert( Object o) {
        connect();

        // construction de la requete d'apres le nom de la classe et le nombre des attributs de la classe
        String  query = "insert into "+o.getClass().getSimpleName().toLowerCase()+" values(?";
        for (int i = 1; i < o.getClass().getDeclaredFields().length; i++) {
            if(!List.class.isAssignableFrom(o.getClass().getDeclaredFields()[i].getType()))
            query += ",?";
        }
        query += ");";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            setParameters(pstmt, o); // voir le code la méthode en bas
            System.out.println(pstmt);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // methode de mise à jours des données
    public boolean update( Object o,String oldid) throws IllegalAccessException {
        connect();
        Field[] fields = o.getClass().getDeclaredFields(); // récupération des attribus de notre classe
        String a ="'";

        // construction de la requete update par le nom de la clasee et le nombre des attributs
        String  query = "UPDATE "+o.getClass().getSimpleName().toLowerCase()+" SET ";
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);// permet l'accès au attributs privés de la classe
            if (!List.class.isAssignableFrom(fields[i].getType())){ // condition pour ignorer les attributs de type list ou array list
                if(fields[i].getType().equals(String.class)){
                    if (i >0){
                        query += ",";
                    }
                    query += fields[i].getName().toLowerCase()+"="+a+fields[i].get(o).toString()+a;
                }else {
                    if (i >0){
                        query += ",";
                    }
                    query += fields[i].getName().toLowerCase()+"="+fields[i].get(o).toString();
                }

            }
        }
        // condition de la requete
        query += " WHERE "+fields[0].getName().toLowerCase()+"="+a+oldid.toString()+a+";";
        System.out.println(query);
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    // méthode de suppression des données
    public boolean delete(Object o) throws IllegalAccessException {
        if (connect()){
            Field[] fields = o.getClass().getDeclaredFields();// récupération des attribus de notre classe
            fields[0].setAccessible(true);// permet l'accès au attributs privés de la classe
            String  a ="'";
            String query = "DELETE FROM "+o.getClass().getSimpleName().toLowerCase()+" WHERE "+fields[0].getName().toLowerCase()+"="+a+fields[0].get(o).toString()+a+";";
            try {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.executeUpdate();

                return true;
            } catch (SQLException e) {
                return false;
            }
        }else return false;
    }

    // methode pour remplacer les '?' d'une requete pars les valeurs des attributs de la classe correspondante
    private static void setParameters(PreparedStatement pstmt, Object obj) throws SQLException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (!List.class.isAssignableFrom(fields[i].getType())){// condition pour ignorer les attributs de type list ou array list
                try {
                    pstmt.setObject(i+1, fields[i].get(obj).toString());
                    System.out.println(pstmt);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // méthode pour convertir les types SQL en types JAVA
    public static Class<?> convertirTypeSQLenTypeJava(String typeSQL) {
        switch (typeSQL.toUpperCase()) {
            case "VARCHAR":
                return String.class;
            case "INT":
                return int.class;
            case "FLOAT":
                return double.class;
            case "DATE":
                return String.class;
            case "TINYINT":
                return int.class;
            default:
                return int.class;
        }
    }

}
