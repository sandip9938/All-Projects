package com.sp.service;

import java.io.*;

import com.sp.bean.AdminBean;
import com.sp.dao.AdminLogDao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminlogin")
public class AdminlogServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String uid = req.getParameter("aname");
		String upw = req.getParameter("apw");
		AdminBean ab= new AdminLogDao().login(uid, upw);
		System.out.println(ab);
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid Login..<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs= req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}
	}
}
