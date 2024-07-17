package com.tracking.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracking.DAO.emp_login_DAO;

@WebServlet("/login1")
public class emp_login_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private emp_login_DAO loginDAO;

    public void init() {
        loginDAO = new emp_login_DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_id = request.getParameter("emp_id");
        String emp_password = request.getParameter("emp_password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        try {
            boolean isValidUser = loginDAO.validate(emp_id, emp_password);
            if (isValidUser) {
                session.setAttribute("emp_name", loginDAO.getEmployeeName(emp_id));
                session.setAttribute("emp_id", emp_id);
                dispatcher = request.getRequestDispatcher("Emp_home.jsp");
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("EmployeeLogin.jsp");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}
