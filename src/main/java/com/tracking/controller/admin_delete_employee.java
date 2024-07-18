package com.tracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin_delete_employee")
public class admin_delete_employee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_id = request.getParameter("emp_id");

        com.tracking.DAO.admin_delete_employeeDAO dao = new com.tracking.DAO.admin_delete_employeeDAO();
        boolean isDeleted = dao.deleteEmployee(emp_id);

        if (isDeleted) {
            response.getWriter().write("Employee record deleted successfully.");
        } else {
            response.getWriter().write("Failed to delete employee record.");
        }
    }
}
