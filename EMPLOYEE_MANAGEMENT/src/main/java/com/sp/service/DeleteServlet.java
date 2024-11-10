package com.sp.service;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.sp.bean.EmployeeBean;
import com.sp.dao.DeleteDao;

@SuppressWarnings("serial")
@WebServlet("/delete") // URL mapping for this servlet
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve the employee ID from the request parameter
        String empIdStr = request.getParameter("eid"); // "eid" should match the name in the form
        HttpSession session = request.getSession();
        String msg;

        if (empIdStr != null && !empIdStr.isEmpty()) {
            try {
                String empId = empIdStr ;// Convert string to integer
                
                // Create an EmployeeBean and set the ID
                EmployeeBean employee = new EmployeeBean();
                employee.setEid(empId);
                
                // Create a DeleteDao instance and call the delete method
                DeleteDao deleteDao = new DeleteDao();
                int rowsAffected = deleteDao.delete(employee);
                
                if (rowsAffected > 0) {
                    msg = "Employee with ID " + empId + " has been deleted successfully.";
                } else {
                    msg = "No employee found with ID " + empId + ".";
                }
            } catch (NumberFormatException e) {
                msg = "Invalid Employee ID format.";
            }
        } else {
            msg = "Invalid Employee ID.";
        }

        // Set the message as a request attribute to display on the result page
        request.setAttribute("msg", msg);
        
        // Redirect to the desired page (e.g., a confirmation page or the employee list page)
        request.getRequestDispatcher("view").forward(request, response);
    }
}


