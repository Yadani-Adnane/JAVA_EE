package com.example.java_jee.model;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Etage {
    private String id_etage;
    private int etat;
    private String id_batiment;
    private int num;

    public Etage(String id_etage, int etat, String id_batiment, int num) {
        this.id_etage = id_etage;
        this.etat = etat;
        this.id_batiment = id_batiment;
        this.num = num;
    }

    public void ajouter(Bd bd){
        bd.insert(this);
    }
    public void supprimer(Bd bd) throws IllegalAccessException {
        bd.delete(this);
    }
    public void modifier(Bd bd,String id_etage) throws IllegalAccessException {
        bd.update(this,id_etage);
    }
    public static Etage chercher(String id_etage,Bd bd ) throws IllegalAccessException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        if( bd.select("*","Etage","id_etage='"+id_etage+"';").size()>0){
            return (Etage) bd.select("*","Etage","id_etage='"+id_etage+"';").get(0);
        }else {
            return null;
        }

    }
    public static Etage tousLesEtages(Bd bd) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return (Etage) bd.select("*","Etage","1=1");
    }
    public static Etage etagesDunBatiment(Bd bd,String id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return (Etage) bd.select("*","Etage","id_batiment='"+id+"'");
    }

    public String getId_etage() {
        return id_etage;
    }

    public int getEtat() {
        return etat;
    }

    public String getId_batiment() {
        return id_batiment;
    }

    public int getNum() {
        return num;
    }

    public void setId_etage(String id_etage) {
        this.id_etage = id_etage;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setId_batiment(String id_batiment) {
        this.id_batiment = id_batiment;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Etage{" +
                "id_etage='" + id_etage + '\'' +
                ", etat=" + etat +
                ", id_batiment='" + id_batiment + '\'' +
                ", num=" + num +
                '}';
    }
}
