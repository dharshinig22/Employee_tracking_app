package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

public class getlast5daysdata_DAO {

    public JSONObject getLast5DaysData(String employeeName) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        JSONObject jsonResponse = new JSONObject();

        try {
            con = Main1DAO.getConnection();
            String query = "SELECT DATE(task_date) AS task_date, SUM(TIME_TO_SEC(duration)) AS total_duration "
                    + "FROM task_table "
                    + "WHERE task_date >= CURDATE() - INTERVAL 5 DAY "
                    + "AND emp_name = ? "
                    + "GROUP BY DATE(task_date) "
                    + "ORDER BY DATE(task_date) ASC";

            pst = con.prepareStatement(query);
            pst.setString(1, employeeName);
            rs = pst.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                String taskDate = sdf.format(rs.getDate("task_date"));
                int totalDurationInSeconds = rs.getInt("total_duration");
                jsonResponse.put(taskDate, totalDurationInSeconds);
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jsonResponse;
    }
}
