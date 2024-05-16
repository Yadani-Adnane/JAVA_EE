package com.example.java_jee.controller;


import com.example.java_jee.model.Bd;
import com.example.java_jee.model.ResidantEtranger;
import com.example.java_jee.model.ResidantLocal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.table.TableModel;
import java.io.IOException;
import java.util.List;

@WebServlet("/ResidentServlet")
public class ResidentServlet extends HttpServlet {
    Bd bd;
    List<ResidantEtranger> re;
    List<ResidantLocal> rel;
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
        if (btn.equals("et")){
            re=ResidantEtranger.getInternationalResidents();
            req.setAttribute("re",re);
            req.getRequestDispatcher("ListResiet.jsp").forward(req, resp);
        }else if (btn.equals("loc")){
            rel=ResidantLocal.getLocalResidents();

            req.setAttribute("rel",rel);
            req.getRequestDispatcher("ListResidentsLoc.jsp").forward(req, resp);
        }

    }
}
