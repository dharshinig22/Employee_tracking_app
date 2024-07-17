package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class emp_login_DAO {

    public boolean validate(String emp_id, String emp_password) throws SQLException {
        String SELECT_SQL = "SELECT emp_id, emp_password FROM employee_table WHERE emp_id = ? AND emp_password = ?";
        
        try (Connection con = Main1DAO.getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT_SQL)) {

            pst.setString(1, emp_id);
            pst.setString(2, emp_password);

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getEmployeeName(String emp_id) throws SQLException {
        String SELECT_SQL = "SELECT emp_name FROM employee_table WHERE emp_id = ?";

        try (Connection con = Main1DAO.getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT_SQL)) {

            pst.setString(1, emp_id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("emp_name");
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
