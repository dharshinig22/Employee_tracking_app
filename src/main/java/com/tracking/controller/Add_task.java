package com.tracking.controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracking.DAO.Add_task_DAO;

/**
 * Servlet implementation class Add_task
 */
@WebServlet("/newtask")
public class Add_task extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emp_id = (String) session.getAttribute("emp_id");
        String emp_name = (String) session.getAttribute("emp_name");
        int task_id = generate_task_id();
        String project_name = request.getParameter("project-name");
        String task_role = request.getParameter("task-role");
        String task_date = request.getParameter("task-date");
        String start_time = request.getParameter("task-start-time");
        String end_time = request.getParameter("task-end-time");
        String duration = request.getParameter("duration");
        String task_category = request.getParameter("task-category");
        String task_description = request.getParameter("task-description");

        RequestDispatcher dispatcher = request.getRequestDispatcher("Emp_home.jsp");

        // Log the received parameters for debugging
        System.out.println("Received parameters:");
        System.out.println("emp_id: " + emp_id);
        System.out.println("emp_name: " + emp_name);
        System.out.println("task_id: " + task_id);
        System.out.println("project_name: " + project_name);
        System.out.println("task_role: " + task_role);
        System.out.println("task_date: " + task_date);
        System.out.println("start_time: " + start_time);
        System.out.println("end_time: " + end_time);
        System.out.println("duration: " + duration);
        System.out.println("task_category: " + task_category);
        System.out.println("task_description: " + task_description);

        try {
            boolean isInserted = Add_task_DAO.insertTask(emp_id, emp_name, String.valueOf(task_id), project_name, task_role, task_date, start_time, end_time,duration, task_category, task_description);
            if (isInserted) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "exception: " + e.getMessage());
        }

        dispatcher.forward(request, response);
    }

    private int generate_task_id() {
        return new Random().nextInt(99999999);
    }
}
