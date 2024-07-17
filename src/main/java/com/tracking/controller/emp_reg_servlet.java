package com.tracking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tracking.DAO.emp_reg_DAO;

@WebServlet("/emp_reg")
public class emp_reg_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private emp_reg_DAO employeeDAO;

    public void init() {
        employeeDAO = new emp_reg_DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_name = request.getParameter("emp_name");
        String phone_num = request.getParameter("phone");
        String email = request.getParameter("email_id");
        String role = request.getParameter("role");
        int age = Integer.parseInt(request.getParameter("age"));
        String emp_pass = request.getParameter("emp_pass");

        String emp_id = generate_employee_id();
        String emp_password = generate_emp_password();

        try {
            System.out.println("Registering employee: " + emp_name + ", " + phone_num + ", " + email + ", " + role + ", " + age);
            employeeDAO.registerEmployee(emp_id, emp_name, phone_num, email, role, age, emp_pass, emp_password);
            response.sendRedirect("EmployeeLogin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Registration failed.", e);
        }
    }

    private String generate_employee_id() {
        return "emp" + new Random().nextInt(999999999);
    }

    private String generate_emp_password() {
        return String.valueOf(new Random().nextInt(99999));
    }
}
