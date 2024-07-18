package com.tracking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.admin_log_DAO;

/**
 * Servlet implementation class admlogServlet
 */
@WebServlet("/adminlogin")
public class admin_log_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private admin_log_DAO adminlogDAO;
    
    public void init() {
        adminlogDAO = new admin_log_DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
        String admin_name = request.getParameter("admin_name");
        String admin_password = request.getParameter("admin_pass");

        try {
            if (adminlogDAO.validate(admin_name, admin_password)) {
                response.sendRedirect("admin_home.jsp"); // Redirect to admin home page
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Login failed. Please check your username and password.</b></body></html>");
            }
        } catch (SQLException e) {
            throw new ServletException("Login failed.", e);
        }
    }
}
