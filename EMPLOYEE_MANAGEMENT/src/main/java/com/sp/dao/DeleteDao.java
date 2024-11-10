package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sp.bean.EmployeeBean;
import com.sp.common.DbConnection;

public class DeleteDao {

    public int delete(EmployeeBean eb) {
        int rowsAffected = 0; // To store the number of affected rows
        Connection con = null; // Connection object
        PreparedStatement ps = null; // PreparedStatement object

        try {
            // Get database connection
            con = DbConnection.geCon();
            
            // Prepare the SQL delete statement
            ps = con.prepareStatement("DELETE FROM Employee65 WHERE EMPID = ?");
            ps.setString(1, eb.getEid()); // Set the EMPID parameter
            
            // Execute the update
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        } finally {
            // Close resources in the finally block to prevent memory leaks
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected; // Return the number of rows affected
    }
}

