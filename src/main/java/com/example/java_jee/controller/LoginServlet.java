package com.example.java_jee.controller;



import com.example.java_jee.model.AuthentificationModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private AuthentificationModel model;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize model
        model = new AuthentificationModel();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isAuthenticated = model.authenticate(username, password);
        if (isAuthenticated) {
            // Redirect to home page or any other page
            response.sendRedirect("homePage.jsp");
        } else {
            // Set error attribute and forward back to login page
            request.setAttribute("error", "Incorrect username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("authentification.jsp");
            dispatcher.forward(request, response);
        }
    }
}