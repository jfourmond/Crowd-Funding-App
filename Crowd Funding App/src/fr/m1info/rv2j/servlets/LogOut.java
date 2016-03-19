package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public final static String view = "/home.jsp";
	
	public final static String SESSION = "session_user";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		session.setAttribute(SESSION, null);
		this.getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
}
