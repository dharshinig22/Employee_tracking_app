package com.tracking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_update_employee")
public class admin_update_employee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_id = request.getParameter("emp_id");
        String new_name = request.getParameter("new_name");
        String new_phone = request.getParameter("new_phone");
        String new_email = request.getParameter("new_email");
        String new_age = request.getParameter("new_age");
        String new_role = request.getParameter("new_role");

        com.tracking.DAO.admin_update_employeeDAO dao = new com.tracking.DAO.admin_update_employeeDAO();
        boolean isUpdated = dao.updateEmployee(emp_id, new_name, new_phone, new_email, new_age, new_role);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_edit_employee.jsp");
        if (isUpdated) {
            response.sendRedirect("admin_edit_employee.jsp"); // Redirect after successful update
        } else {
            request.setAttribute("message", "Failed to update employee details.");
            dispatcher.forward(request, response); // Forward on failure
        }
    }
}
