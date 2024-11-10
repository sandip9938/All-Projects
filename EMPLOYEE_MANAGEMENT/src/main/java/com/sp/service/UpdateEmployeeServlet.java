package com.sp.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.sp.bean.EmployeeBean;
import com.sp.dao.UpdateEmployeeDao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Seassion Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
			ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>) hs.getAttribute("alist");
			String eid = req.getParameter("eid");

			Iterator<EmployeeBean> it = al.iterator();
			EmployeeBean eb = (EmployeeBean) it.next();
			if (eid.equals(eb.getEid())) {
				int ebsal = Integer.parseInt(req.getParameter("bsal"));
				float ehra = 0.93F * ebsal;
				float eda = 0.61F * ebsal;
				float etsal = ebsal + ehra + eda;
				eb.setEbsal(ebsal);
				eb.setEhra(ehra);
				eb.setEda(eda);
				eb.setEtsal(etsal);
				int p = new UpdateEmployeeDao().update(eb);
				System.out.println(p);
				if (p > 0) {
					req.setAttribute("msg", "Employee Updated Sucessfully...<br>");
					req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, res);
				}
			}
		}
	}
}