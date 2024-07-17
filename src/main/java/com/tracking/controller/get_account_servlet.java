package com.tracking.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class get_Account_details
 */
@WebServlet("/get1")
public class get_account_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone_num = request.getParameter("phone_number");
        String emp_pass = request.getParameter("password");
        RequestDispatcher dispatcher = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/time_tracker", "root", "Dharshu@22");
            PreparedStatement pst = con.prepareStatement("SELECT emp_id, emp_password FROM employee_table WHERE phone_num = ? AND emp_pass = ?");

            pst.setString(1, phone_num);
            pst.setString(2, emp_pass);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String emp_id = rs.getString("emp_id");
                String emp_password = rs.getString("emp_password");
                request.setAttribute("emp_id", emp_id);
                request.setAttribute("emp_password", emp_password);
                dispatcher = request.getRequestDispatcher("EmployeeLogin.jsp");
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("EmployeeLogin.jsp");
            }
            dispatcher.forward(request, response);

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}