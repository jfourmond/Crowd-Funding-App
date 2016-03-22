package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.UserDAO;
import fr.m1info.rv2j.forms.UserConnection;

public class LogIn extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";

	public final static String view_form = "/WEB-INF/login.jsp";
	
	public final static String path_success = "account";

	public final static String USERNAME = "username";
	public final static String FORM = "form";
	public final static String SESSION = "session_user";
	
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		this.userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		UserConnection form = new UserConnection(userDAO);
		User user = form.connectUser(req);
		
		req.setAttribute(FORM, form);
		
		if(user != null) {
			session.setAttribute(SESSION, user);
			resp.sendRedirect(resp.encodeRedirectURL(path_success));
		} else {
			session.setAttribute(SESSION, null);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
}
