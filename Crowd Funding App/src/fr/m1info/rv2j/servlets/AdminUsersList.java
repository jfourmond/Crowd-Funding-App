package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.UserDAO;

public class AdminUsersList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view = "/WEB-INF/admin/users_list.jsp";
	public final static String view_add = "/WEB-INF/admin/user_add.jsp";
	public final static String view_edit = "/WEB-INF/admin/user_edit.jsp";
	
	public final static String SESSION = "session_user";
	
	public final static String USERS = "users";
	public final static String USER = "user";
	
	
	private UserDAO userDAO;
	
	private List<User> users;
	
	@Override
	public void init() throws ServletException {
		this.userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
		users = userDAO.getAllUsers();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		if(user_session == null || user_session.getRightLevel() != 2) {
			resp.sendError(401);
		} else {
			users = userDAO.getAllUsers();
			req.setAttribute(USERS, users);
			this.getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String delete = req.getParameter("delete");
		String edit = req.getParameter("edit");
		String add = req.getParameter("add");
		
		if(delete != null) {
			userDAO.deleteByID(delete);
			this.doGet(req, resp);
		}
		if(edit != null) {
			User user = userDAO.findByID(edit);
			req.setAttribute(USER, user);
			this.getServletContext().getRequestDispatcher(view_edit).forward(req, resp);
		}
		if(add != null) {
			this.getServletContext().getRequestDispatcher(view_add).forward(req, resp);
		}
	}
}
