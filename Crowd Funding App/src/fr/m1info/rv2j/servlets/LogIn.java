package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public final static String view = "/WEB-INF/login.jsp";
	public static String username;
	public static String password;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message_username = "";
		String message_password = "";
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		if (username.trim().equals("a")) {
			message_username = "Identifiant inconnu !";
		}
		if (password.trim().equals("a")) {
			message_password = "Mot de passe incorrecte !";
		}
		
		req.setAttribute("message_username", message_username);
		req.setAttribute("message_password", message_password);
		this.getServletContext().getRequestDispatcher(view).forward( req, resp );
		//super.doPost(req, resp);
	}
	
}
