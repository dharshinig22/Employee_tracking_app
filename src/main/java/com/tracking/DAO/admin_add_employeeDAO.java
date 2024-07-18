package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tracking.DAO.Main1DAO;

public class admin_add_employeeDAO {

    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employee_table (emp_id, emp_name, phone_num, email, age, role, emp_pass, emp_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean addEmployee(int emp_id, String emp_name, String phone_num, String email, int age, String role, String emp_pass, String emp_password) {
        boolean rowInserted = false;
        try (Connection connection = Main1DAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            preparedStatement.setInt(1, emp_id);
            preparedStatement.setString(2, emp_name);
            preparedStatement.setString(3, phone_num);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, role);
            preparedStatement.setString(7, emp_pass);
            preparedStatement.setString(8, emp_password);

            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
}
