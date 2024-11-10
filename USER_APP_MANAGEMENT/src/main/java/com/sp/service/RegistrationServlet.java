
package com.sp.service;

import java.io.IOException;

import com.sp.bean.UserBean;
import com.sp.dao.RegistrationDao;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/reg")
@SuppressWarnings("serial")
public class RegistrationServlet extends GenericServlet {

	public void init(ServletConfig cs) throws ServletException {
		// No code
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserBean rBean = new UserBean();
		rBean.setUserid(req.getParameter("userid"));
		rBean.setPwd(req.getParameter("upw"));
		rBean.setUfn(req.getParameter("ufn"));
		rBean.setUln(req.getParameter("uln"));
		rBean.setUad(req.getParameter("uad"));
		rBean.setUmid(req.getParameter("umid"));
		rBean.setUno(Long.parseLong(req.getParameter("uno")));
		RegistrationDao rd = new RegistrationDao();

		int k = rd.register(rBean);
		if (k > 0) {
			req.setAttribute("msg", "User SucessFully Registered....... <br>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Registration.jsp");
			requestDispatcher.forward(req, res);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.html");
			requestDispatcher.include(req, res);
		}

	}

	public void destroy() {

	}

}
