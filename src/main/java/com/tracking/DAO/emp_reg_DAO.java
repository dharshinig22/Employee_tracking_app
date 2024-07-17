package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class emp_reg_DAO {

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee_table (emp_id, emp_name, phone_num, email, role, age, emp_pass, emp_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    public emp_reg_DAO() {}

    public void registerEmployee(String emp_id, String emp_name, String phone_num, String email, String role, int age, String emp_pass, String emp_password) throws SQLException {
        try (Connection connection = Main1DAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, emp_id);
            preparedStatement.setString(2, emp_name);
            preparedStatement.setString(3, phone_num);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, role);
            preparedStatement.setInt(6, age);
            preparedStatement.setString(7, emp_pass);
            preparedStatement.setString(8, emp_password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
            throw e;
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
