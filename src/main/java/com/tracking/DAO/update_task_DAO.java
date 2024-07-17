package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update_task_DAO {

    public boolean updateTask(String taskId, String empId, String empName, String projectName, String taskRole, String taskDate, String startTime, String endTime, String taskCategory, String taskDescription) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = Main1DAO.getConnection();
            String sql = "UPDATE task_table SET emp_id = ?, emp_name = ?, project_name = ?, task_role = ?, task_date = ?, start_time = ?, end_time = ?, task_category = ?, task_description = ? WHERE task_id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, empId);
            pst.setString(2, empName);
            pst.setString(3, projectName);
            pst.setString(4, taskRole);
            pst.setString(5, taskDate);
            pst.setString(6, startTime);
            pst.setString(7, endTime);
            pst.setString(8, taskCategory);
            pst.setString(9, taskDescription);
            pst.setString(10, taskId);

            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
