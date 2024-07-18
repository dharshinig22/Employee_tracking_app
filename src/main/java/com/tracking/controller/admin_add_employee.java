package com.tracking.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.*;

/**
 * Servlet implementation class admin_add_employee
 */
@WebServlet("/admin_add_emp")
public class admin_add_employee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_name = request.getParameter("name");
        String phone_num = request.getParameter("phone_num");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String role = request.getParameter("employee_role");
        String emp_pass = request.getParameter("emp_pass");

        int emp_id = generate_employee_id();
        String emp_password = generate_employee_password();

        com.tracking.DAO.admin_add_employeeDAO dao = new com.tracking.DAO.admin_add_employeeDAO();
        boolean isInserted = dao.addEmployee(emp_id, emp_name, phone_num, email, age, role, emp_pass, emp_password);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_home.jsp");
        if (isInserted) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        dispatcher.forward(request, response);
    }

    private int generate_employee_id() {
        return new Random().nextInt(99999999);
    }

    private String generate_employee_password() {
        return String.valueOf(new Random().nextInt(999999));
    }
}
