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

@WebServlet(name = "DeleteResiServlet", value = "/DeleteResi-Servlet")
public class DeleteResiServlet extends HttpServlet {
    Bd bd;
    ResidantEtranger re;
    ResidantLocal rel;

    @Override
    public void init() throws ServletException {
        bd = new Bd();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resi = req.getParameter("resi");
        if (resi.equals("et")) {
            re = new ResidantEtranger();
            re.supprimer(req.getParameter("id"));
            req.setAttribute("btn","et");
            req.getRequestDispatcher("/Resident-Servlet").forward(req, resp);
        }else{
            rel = new ResidantLocal();
            re.supprimer(req.getParameter("id"));
            req.setAttribute("btn","et");
            req.getRequestDispatcher("/Resident-Servlet").forward(req, resp);
        }

    }
}
