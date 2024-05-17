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

@WebServlet("/DeleteResiServlet")
public class DeleteResiServlet extends HttpServlet {
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
        String resi = req.getParameter("resi");
        if (resi.equals("et")) {
            re = new ResidantEtranger();
            re.supprimer(req.getParameter("id"));
            resp.sendRedirect("ResidentServlet?btn=et");
        }else{
            rel = new ResidantLocal();
            System.out.println(req.getParameter("id"));
            rel.supprimer(req.getParameter("id"));
            resp.sendRedirect("ResidentServlet?btn=loc");
        }

    }
}
