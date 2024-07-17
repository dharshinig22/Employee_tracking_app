package com.tracking.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.delete_task_DAO;

@WebServlet("/delete-task")
public class delete_task extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("task_id");

        if (taskId != null && !taskId.isEmpty()) {
            delete_task_DAO deleteTaskDAO = new delete_task_DAO();

            try {
                boolean isDeleted = deleteTaskDAO.deleteTask(taskId);

                if (isDeleted) {
                    response.sendRedirect("Emp_home.jsp");
                } else {
                    response.getWriter().println("No task found with the provided task ID for today.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error occurred: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Task ID is required.");
        }
    }
}
