package com.example.java_jee.model;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Chambre {
    private String id_chambre;
    private int num;
    private int etat;
    private String id_etage;
    private int reservee;

    public Chambre(String id_chambre, int num, int etat, String id_etage, int reservee) {
        this.id_chambre = id_chambre;
        this.num = num;
        this.etat = etat;
        this.id_etage = id_etage;
        this.reservee = reservee;
    }

    public void ajouter(Bd bd){
        bd.insert(this);
    }
    public void supprimer(Bd bd) throws IllegalAccessException {
        bd.delete(this);
    }
    public void modifier(Bd bd, String id) throws IllegalAccessException {
        bd.update(this,id);
    }
    public static Chambre chercher(String id_chambre,Bd bd) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(bd.select("*","Chambre","id_chambre = '"+id_chambre+"';").size()>0){
            return (Chambre) bd.select("*","Chambre","id_chambre = '"+id_chambre+"';").get(0);
        }else {
            return null;
        }

    }
    public static Chambre tousLesChambres(Bd bd) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return (Chambre) bd.select("*","Chambre","1=1");
    }
    public static Chambre chambresDunEtage(Bd bd,String id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return (Chambre) bd.select("*","Chambre","id_etage = '"+id+"'");
    }

    public String getId_chambre() {
        return id_chambre;
    }

    public int getNum() {
        return num;
    }

    public int getEtat() {
        return etat;
    }

    public String getId_etage() {
        return id_etage;
    }

    public int getReservee() {
        return reservee;
    }

    public void setId_chambre(String id_chambre) {
        this.id_chambre = id_chambre;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setId_etage(String id_etage) {
        this.id_etage = id_etage;
    }

    public void setReservee(int reservee) {
        this.reservee = reservee;
    }
}
