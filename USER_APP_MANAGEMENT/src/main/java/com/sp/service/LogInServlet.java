
package com.sp.service;

import java.io.*;

import com.sp.bean.UserBean;
import com.sp.dao.LoginDao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LogInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid = req.getParameter("userid");
		String pw = req.getParameter("upw");
		LoginDao ld = new LoginDao();
		UserBean ub = ld.login(uid, pw);
		if (ub == null) {

		} else {
			ServletContext sct = req.getServletContext();
			sct.setAttribute("ubean", ub);
			Cookie ck = new Cookie("ufn", ub.getUfn());
			res.addCookie(ck);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
	}

	public void destroy() {

	}
}
