package com.example.java_jee.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;



public class GestionResidantLocalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers la page gestionresidentlocal.jsp
        response.sendRedirect("gestionResidentLocal.jsp");
    }
}
