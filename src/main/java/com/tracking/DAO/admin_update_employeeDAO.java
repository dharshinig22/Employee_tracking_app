package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tracking.DAO.Main1DAO;

public class admin_update_employeeDAO {

    public boolean updateEmployee(String emp_id, String new_name, String new_phone, String new_email, String new_age, String new_role) {
        boolean rowUpdated = false;
        StringBuilder sql = new StringBuilder("UPDATE employee_table SET ");
        boolean first = true;

        if (new_name != null && !new_name.isEmpty()) {
            sql.append("emp_name = ?");
            first = false;
        }
        if (new_phone != null && !new_phone.isEmpty()) {
            if (!first) sql.append(", ");
            sql.append("phone_num = ?");
            first = false;
        }
        if (new_email != null && !new_email.isEmpty()) {
            if (!first) sql.append(", ");
            sql.append("email = ?");
        }
        if (new_age != null && !new_age.isEmpty()) {
            if (!first) sql.append(", ");
            sql.append("age = ?");
            first = false;
        }
        if (new_role != null && !new_role.isEmpty()) {
            if (!first) sql.append(", ");
            sql.append("role = ?");
            first = false;
        }
        
        sql.append(" WHERE emp_id = ?");

        try (Connection con = Main1DAO.getConnection();
             PreparedStatement pst = con.prepareStatement(sql.toString())) {

            int index = 1;
            if (new_name != null && !new_name.isEmpty()) {
                pst.setString(index++, new_name);
            }
            if (new_phone != null && !new_phone.isEmpty()) {
                pst.setString(index++, new_phone);
            }
            if (new_email != null && !new_email.isEmpty()) {
                pst.setString(index++, new_email);
            }
            if (new_age != null && !new_age.isEmpty()) {
                pst.setString(index++, new_age);
            }
            if (new_role != null && !new_role.isEmpty()) {
                pst.setString(index++, new_role);
            }
            pst.setString(index, emp_id);

            rowUpdated = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
