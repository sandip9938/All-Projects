
package com.sp.service;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/edit")

public class EditProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c[] = req.getCookies();
		if (c == null) {
			req.setAttribute("msg", "Session Expired.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
			String fnString = c[0].getValue();
			req.setAttribute("ufn", fnString);
			req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
		}
	}
}
