package com.tracking.controller;

import com.tracking.DAO.update_task_DAO;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update_task
 */
@WebServlet("/update_task")
public class update_task extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("task_id");
        String empId = request.getParameter("emp_id");
        String empName = request.getParameter("emp_name");
        String projectName = request.getParameter("project_name");
        String taskRole = request.getParameter("task_role");
        String taskDate = request.getParameter("task_date");
        String startTime = request.getParameter("start_time");
        String endTime = request.getParameter("end_time");
        String taskCategory = request.getParameter("task_category");
        String taskDescription = request.getParameter("task_description");

        update_task_DAO updateTaskDAO = new update_task_DAO();

        try {
            boolean isUpdated = updateTaskDAO.updateTask(taskId, empId, empName, projectName, taskRole, taskDate, startTime, endTime, taskCategory, taskDescription);
            if (isUpdated) {
                response.sendRedirect("edit-task.jsp?status=success");
            } else {
                response.sendRedirect("edit-task.jsp?status=error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("edit-task.jsp?status=error");
        }
    }
}
