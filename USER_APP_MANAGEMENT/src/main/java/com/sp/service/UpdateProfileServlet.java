package com.sp.service;

import java.io.*;

import com.sp.bean.UserBean;
import com.sp.dao.UpdateProfileDao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c[] = req.getCookies();// unmae

		if (c == null) {

			req.setAttribute("msg", "Seassion Expired..<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {

			String fnString = c[0].getValue();
			req.setAttribute("ufn", fnString);
			ServletContext sctContext = req.getServletContext();
			UserBean uBean = (UserBean) sctContext.getAttribute("ubean");
			uBean.setUad(req.getParameter("uad"));
			uBean.setUmid(req.getParameter("umid"));
			uBean.setUno(Long.parseLong(req.getParameter("uno")));
			int k = new UpdateProfileDao().update(uBean);

			if (k > 0) {
				req.setAttribute("msg", "Profile Updated Sucessfully...<br>");
				req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			}
		}
	}

}