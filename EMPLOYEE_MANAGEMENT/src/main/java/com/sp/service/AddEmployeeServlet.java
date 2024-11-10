package com.sp.service;

import java.io.*;

import com.sp.bean.EmployeeBean;
import com.sp.dao.AddEmployeeDao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings({ "serial" })
@WebServlet("/employeeadd")
public class AddEmployeeServlet  extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs= req.getSession(false);
		System.out.println(hs);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			EmployeeBean eb= new EmployeeBean();
			eb.setEid(req.getParameter("eid"));
			eb.setEname(req.getParameter("ename"));
			eb.setEdesg(req.getParameter("edesg"));
			int ebsal=Integer.parseInt(req.getParameter("ebsal"));
			float ehra=0.93F*ebsal;
			float eda = 0.61F*ebsal;
			float etsal=ebsal+ehra+eda;
			eb.setEbsal(ebsal);
			eb.setEhra(ehra);
			eb.setEda(eda);
			eb.setEtsal(etsal);
			int k = new AddEmployeeDao().insert(eb);
					if(k>0)
					{
						req.setAttribute("msg", "Employee Added Sucessfully...<br>");
						req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
					}
		}
	}
}
