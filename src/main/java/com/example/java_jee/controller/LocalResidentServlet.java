package com.example.java_jee.controller;

import com.example.java_jee.model.ResidantLocal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LocalResidentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve local resident data
        List<ResidantLocal> localResidents = ResidantLocal.getLocalResidents();

        // Set the retrieved data as an attribute in the request
        request.setAttribute("localResidents", localResidents);

        // Forward the request to the gestiondesresidant page
        request.getRequestDispatcher("gestiondesresidant.jsp").forward(request, response);
    }
}
