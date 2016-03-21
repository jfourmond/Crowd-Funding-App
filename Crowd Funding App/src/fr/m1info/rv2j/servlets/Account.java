package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.ProjectDAO;

public class Account extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view = "/WEB-INF/account.jsp";
	public final static String SESSION = "session_user";
	
	public final static String PROJECTS = "projects";
	
	ProjectDAO projectDAO;
	
	@Override
	public void init() throws ServletException {
		projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		List<Project> projects;
		if(user_session == null)
			resp.sendError(401);
		else {
			projects = projectDAO.findByAuthorID(String.valueOf(user_session.getID()));
			// session.setAttribute(SESSION, user);
			req.setAttribute(PROJECTS, projects);
			this.getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
}
