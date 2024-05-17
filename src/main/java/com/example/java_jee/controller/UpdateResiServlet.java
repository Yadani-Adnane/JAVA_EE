package com.example.java_jee.controller;


import com.example.java_jee.model.Bd;
import com.example.java_jee.model.ResidantEtranger;
import com.example.java_jee.model.ResidantLocal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UpdateResiServlet")
public class UpdateResiServlet extends HttpServlet {
    Bd bd;
    ResidantEtranger re;
    ResidantLocal rel;

    @Override
    public void init() throws ServletException {
        bd = new Bd();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        String resi = req.getParameter("resi");
        System.out.println(btn+resi);
        if (btn.equals("update")) {
            if(resi.equals("et")){
                req.getRequestDispatcher("interResidentUpDateForm.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("localResidentUpDateForm.jsp").forward(req, resp);
            }

        } else if (btn.equals("save")) {
            if (resi.equals("et")) {
                String nom = req.getParameter("nom");
                String prenom = req.getParameter("prenom");
                String adresse = req.getParameter("adresse");
                String email = req.getParameter("email");
                String tel = req.getParameter("tel");
                String id = req.getParameter("id");
                String dateDeNaissance = req.getParameter("dateDeNaissance");
                String universite = req.getParameter("universite");
                String genre = req.getParameter("genre");
                String dateEntre = req.getParameter("dateEntre");
                String dateSortie= req.getParameter("dateSortie");
                String etat = req.getParameter("etat");
                String idChambre = req.getParameter("idChambre");
                String telGarant =req.getParameter("telGarant");
                String programmeDetude = req.getParameter("programmeDetude");
                int reservationNonPayees = Integer.parseInt(req.getParameter("reservationNonPayees"));
                String numPassport = req.getParameter("numPassport");
                String pays = req.getParameter("pays");
                re = new ResidantEtranger(nom, prenom,  dateDeNaissance,  tel, adresse,  id, email,  genre,  dateEntre,  dateSortie,  etat,  universite, idChambre,  telGarant, programmeDetude,  reservationNonPayees,
                        numPassport,  pays);
                try {
                    re.modifier(id);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect("ResidentServlet?btn=et");
            } else if (resi.equals("loc")) {
                String nom = req.getParameter("nom");
                String prenom = req.getParameter("prenom");
                String adresse = req.getParameter("adresse");
                String email = req.getParameter("email");
                String tel = req.getParameter("tel");
                String id = req.getParameter("id");
                String dateDeNaissance = req.getParameter("dateDeNaissance");
                String universite = req.getParameter("universite");
                String genre = req.getParameter("genre");
                String dateEntre = req.getParameter("dateEntre");
                String dateSortie = req.getParameter("dateSortie");
                String etat = req.getParameter("etat");
                String idChambre = req.getParameter("idChambre");
                String telGarant = req.getParameter("telGarant");
                String programmeDetude = req.getParameter("programmeDetude");
                int reservationNonPayees = Integer.parseInt(req.getParameter("reservationNonPayees"));
                String cin = req.getParameter("cin");
                String CNE = req.getParameter("CNE");
                rel = new ResidantLocal( nom,  prenom,  dateDeNaissance,  tel,  adresse,  id, email,  genre,  dateEntre,  dateSortie,  etat,  universite, idChambre,  telGarant,  programmeDetude,  reservationNonPayees, CNE,  cin);
                try {
                    rel.modifier(id);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect("ResidentServlet?btn=loc");
            }
        }
    }
}
