package com.example.java_jee.model;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Reservation {
    private int id_reservation;
    private String date_reservation;
    private String id_residant;
    private String id_chambre;
    private int payee;
    private String recu;
    private double frais_de_reservation;

    public Reservation(int id_reservation, String date_reservation, String id_residant, String id_chambre, int payee, String recu, double frais_de_reservation) {
        this.id_reservation=id_reservation;
        this.date_reservation=date_reservation;
        this.id_residant = id_residant;
        this.id_chambre=id_chambre;
        this.payee=payee;
        this.recu=recu;
        this.frais_de_reservation=frais_de_reservation;
    }

    public void ajouter(Bd bd){
        bd.insert(this);
    }

    public void payer(String recu) throws IllegalAccessException {
        this.payee=1;
        this.recu=recu;
        Bd b = new Bd();
        b.update(this, String.valueOf(this.id_reservation));
    }

    public void supprimer(Bd bd) throws IllegalAccessException {
        bd.delete(this);
    }

    public static Reservation tousLesReservation(Bd bd) throws IllegalAccessException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        return (Reservation) bd.select("*","Reservation","1=1");
    }

    public static Reservation rservationsDunResidant(Bd bd,String id) throws IllegalAccessException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        return (Reservation) bd.select("*","Reservation","id_residant = '"+id+"'");
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public String getId_residant() {
        return id_residant;
    }

    public String getId_chambre() {
        return id_chambre;
    }

    public int getPayee() {
        return payee;
    }

    public String getRecu() {
        return recu;
    }

    public double getFrais_de_reservation() {
        return frais_de_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setId_residant(String id_residant) {
        this.id_residant = id_residant;
    }

    public void setId_chambre(String id_chambre) {
        this.id_chambre = id_chambre;
    }

    public void setPayee(int payee) {
        this.payee = payee;
    }

    public void setRecu(String recu) {
        this.recu = recu;
    }

    public void setFrais_de_reservation(double frais_de_reservation) {
        this.frais_de_reservation = frais_de_reservation;
    }

    @Override
    public String
    toString() {
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", date_reservation='" + date_reservation + '\'' +
                ", id_residant='" + id_residant + '\'' +
                ", id_chambre='" + id_chambre + '\'' +
                ", payee=" + payee +
                ", recu='" + recu + '\'' +
                ", frais_de_reservation=" + frais_de_reservation +
                '}';
    }
}
