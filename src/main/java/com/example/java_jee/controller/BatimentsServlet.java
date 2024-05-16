package com.example.java_jee.controller;


import com.example.java_jee.model.Batiment;
import com.example.java_jee.model.Bd;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BatimentsServlet", value = "/Batiments-Servlet")
public class BatimentsServlet extends HttpServlet {
    Bd bd;
    List<Object> batiments;

    @Override
    public void init() throws ServletException {
        bd = new Bd();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            batiments = Batiment.tousLesBatiments(bd) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
