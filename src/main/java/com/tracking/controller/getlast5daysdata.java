package com.tracking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

import com.tracking.DAO.getlast5daysdata_DAO;

@WebServlet("/GetLast5DaysData")
public class getlast5daysdata extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonResponse = new JSONObject();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String employeeName = (String) session.getAttribute("emp_name");

            if (employeeName != null && !employeeName.isEmpty()) {
                getlast5daysdata_DAO dao = new getlast5daysdata_DAO();
                try {
                    jsonResponse = dao.getLast5DaysData(employeeName);
                } catch (SQLException e) {
                    e.printStackTrace();
                    jsonResponse.put("error", e.getMessage());
                }
            } else {
                jsonResponse.put("error", "Employee name not found in session");
            }
        } else {
            jsonResponse.put("error", "Session not found");
        }

        out.print(jsonResponse.toString());
        out.flush();
    }
}
