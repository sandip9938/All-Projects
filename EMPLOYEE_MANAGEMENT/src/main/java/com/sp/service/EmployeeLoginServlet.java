package com.sp.service;

import java.io.*;

import com.sp.bean.EmployeeBean;
import com.sp.dao.EmployeeLoginDao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/employeelogin")
public class EmployeeLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String eid = req.getParameter("eid");
		
		EmployeeBean eb= new EmployeeLoginDao().login(eid);
		System.out.println(eb);
		if(eb==null)
		{
			req.setAttribute("msg", "Invalid Login..<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs= req.getSession();
			hs.setAttribute("ebean", eb);
			req.getRequestDispatcher("EmployeeLogin.jsp").forward(req, res);
		}
	}
}
