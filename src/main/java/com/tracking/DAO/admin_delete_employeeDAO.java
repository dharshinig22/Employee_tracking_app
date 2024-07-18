package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tracking.DAO.Main1DAO;

public class admin_delete_employeeDAO {

    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee_table WHERE emp_id = ?";

    public boolean deleteEmployee(String emp_id) {
        boolean rowDeleted = false;

        try (Connection con = Main1DAO.getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            pst.setString(1, emp_id);

            rowDeleted = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
