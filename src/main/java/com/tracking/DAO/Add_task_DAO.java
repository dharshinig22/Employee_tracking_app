package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_task_DAO {
    public static boolean insertTask(String emp_id, String emp_name, String task_id, String project_name, String task_role, String task_date, String start_time, String end_time,String duration, String task_category, String task_description) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        boolean isInserted = false;

        try {
            con = Main1DAO.getConnection();
            pst = con.prepareStatement("INSERT INTO task_table (emp_id, emp_name, task_id, project_name, task_role, task_date, start_time, end_time, duration,task_category, task_description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");

            pst.setString(1, emp_id);
            pst.setString(2, emp_name);
            pst.setString(3, task_id);
            pst.setString(4, project_name);
            pst.setString(5, task_role);
            pst.setString(6, task_date);
            pst.setString(7, start_time);
            pst.setString(8, end_time);
            pst.setString(9, duration);
            pst.setString(10, task_category);
            pst.setString(11, task_description);

            // Log the query for debugging
            System.out.println("Executing query: " + pst.toString());

            int rowcount = pst.executeUpdate();
            isInserted = rowcount > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return isInserted;
    }
}
