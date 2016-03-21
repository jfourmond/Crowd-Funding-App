package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.ProjectDAO;
import fr.m1info.rv2j.forms.ProjectCreation;

public class ProjectAdd extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view_form = "/WEB-INF/project_add.jsp";
	public final static String view_success = "/WEB-INF/project.jsp";
	
	public final static String SESSION = "session_user";
	
	public final static String PROJECT = "project";
	public final static String FORM = "form";
	
	ProjectDAO projectDAO;
	
	@Override
	public void init() throws ServletException {
		projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		if(user_session == null || user_session.getRightLevel() == 0) {
			resp.sendError(401);
		} else {
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Project project;
		
		ProjectCreation form = new ProjectCreation(projectDAO);
		
		project = form.createProject(req);
		
		req.setAttribute(PROJECT, project);
		req.setAttribute(FORM, form);
		
		if (form.getErrors().isEmpty())
			this.getServletContext().getRequestDispatcher(view_success).forward(req, resp);
		else
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
	}
}
