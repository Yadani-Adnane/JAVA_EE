package com.example.java_jee.controller;


import com.example.java_jee.model.Batiment;
import com.example.java_jee.model.Bd;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BatimentController", value = "/Batiment-Controller")
public class BatimentController extends HttpServlet {
    private Batiment b;
    private Bd bd;
    private String message;

    public void init() {
        bd = new Bd();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                break;
            case "/insert":
                b= new Batiment(request.getParameter("id_abtiment"),request.getParameter("genre"),Integer.parseInt(request.getParameter("etat")));
                b.ajouter(bd);
                break ;
            case "/delete":
                b= new Batiment(request.getParameter("id_abtiment"),request.getParameter("genre"),Integer.parseInt(request.getParameter("etat")));
                try {
                    b.supprimer(bd);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                break ;
            case "/update":
                b= new Batiment(request.getParameter("id_abtiment"),request.getParameter("genre"),Integer.parseInt(request.getParameter("etat")));
                try {
                    b.modifier(bd,request.getParameter("old_id_abtiment"));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                break ;
            default :
                break ;
        }
    }
}
