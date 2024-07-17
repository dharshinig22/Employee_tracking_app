package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete_task_DAO {

    public boolean deleteTask(String taskId) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = Main1DAO.getConnection();
            String query = "DELETE FROM task_table WHERE task_id = ? AND task_date = CURDATE()";
            pst = con.prepareStatement(query);
            pst.setString(1, taskId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
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
