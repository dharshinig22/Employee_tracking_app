package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TaskDAO {

    public Map<String, Double> getTaskData() throws SQLException {
        String query = "SELECT task_category, TIME_TO_SEC(duration) AS duration_seconds FROM task_table";
        Map<String, Double> taskData = new HashMap<>();

        try (Connection conn = Main1DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String category = rs.getString("task_category");
                double duration = rs.getDouble("duration_seconds");
                taskData.put(category, taskData.getOrDefault(category, 0.0) + duration);
            }
        }

        return taskData;
    }
}
