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
import fr.m1info.rv2j.forms.AdminUserEdition;

public class UserEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view_form = "/WEB-INF/admin/user_edit.jsp";
	public final static String view_success = "/WEB-INF/admin/users_list.jsp";
	
	public final static String SESSION = "session_user";
	
	public final static String USER = "user";
	public final static String FORM = "form";
	
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		User user;
		if(user_session == null || user_session.getRightLevel() != 2) {
			resp.sendError(401);
		} else {
			user = (User) req.getAttribute(USER);
			req.setAttribute(USER, user);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user;
		AdminUserEdition form = new AdminUserEdition(userDAO);
		
		user = form.editUser(req);
		
		req.setAttribute(USER, user);
		req.setAttribute(FORM, form);
		
		if (form.getErrors().isEmpty())
			this.getServletContext().getRequestDispatcher(view_success).forward(req, resp);
		else
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
	}
	
}
