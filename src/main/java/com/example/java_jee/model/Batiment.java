package com.example.java_jee.model;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Batiment {
    private String id_batiment,genre;
    private int etat;

    public Batiment(String id_batiment, String genre, int etat) {
        this.id_batiment = id_batiment;
        this.genre = genre;
        this.etat = etat;
    }

     public void ajouter(Bd bd) {
         bd.insert(this);
     }
     public void modifier(Bd bd,String oldid) throws IllegalAccessException {
        bd.update(this,oldid);
     }
     public void supprimer(Bd bd) throws IllegalAccessException {
        bd.delete(this);
     }
     public static Batiment chercher(String id_batiment,Bd bd) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(bd.select("*","Batiment","id_batiment = '"+id_batiment+"';").size()>0){
            return (Batiment) bd.select("*","Batiment","id_batiment = '"+id_batiment+"';").get(0);
        }else {
            return null;
        }

     }
     public static List<Object> tousLesBatiments(Bd bd) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return bd.select("*","Batiment","1=1");
     }

     public String getId_batiment() {
        return id_batiment;
    }
     public String getGenre() {
        return genre;
    }
     public int getEtat() {
        return etat;
    }
     public void setId_batiment(String id_batiment) {
        this.id_batiment = id_batiment;
    }
     public void setGenre(String genre) {
        this.genre = genre;
    }
     public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "id_batiment='" + id_batiment + '\'' +
                ", genre='" + genre + '\'' +
                ", etat=" + etat +
                '}';
    }
}
