package com.sp.service;

import java.io.*;
import java.util.*;

import com.sp.bean.EmployeeBean;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/edits")
public class EditEmployeeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			@SuppressWarnings("unchecked")
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");
			String eid=req.getParameter("eid");
//			System.out.println(eid);
			Iterator<EmployeeBean> it=al.iterator();
			while(it.hasNext())
			{
				EmployeeBean eb=(EmployeeBean)it.next();
				if(eid.equals(eb.getEid()))
				{
					req.setAttribute("ebean", eb);
					req.getRequestDispatcher("EditEmployee.jsp").forward(req, res);
					break;
				}
			}
	
		}
	}
}
