package com.sp.service;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		System.out.println(hs);
		if(hs==null)
		{
			req.setAttribute("msg", "Seassion Expiered....<br>");
		}
		else {
			hs.removeAttribute("abean");
			hs.removeAttribute("alist");
			hs.invalidate();
			req.setAttribute("msg","Logged Out Successfully...<br>");
		}
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
}
