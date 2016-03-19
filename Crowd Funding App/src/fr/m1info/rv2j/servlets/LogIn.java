package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.UserDAO;
import fr.m1info.rv2j.forms.UserConnection;

public class LogIn extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";

	public final static String view_form = "/WEB-INF/login.jsp";
	public final static String view_success = "/WEB-INF/account.jsp";

	public final static String USERNAME = "username";
	public final static String FORM = "form";
	
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		this.userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		
		User user = userDAO.findByName("test1");
		System.out.println(user);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserConnection form = new UserConnection(userDAO);
		
		User user = form.connectUser(req);
		
		req.setAttribute(FORM, form);
		
		if(user != null) {
			System.out.println(user);
			this.getServletContext().getRequestDispatcher(view_success).forward(req, resp);
		} else 
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
	}
	
}
