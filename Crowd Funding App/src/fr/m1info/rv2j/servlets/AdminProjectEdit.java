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
import fr.m1info.rv2j.forms.AdminProjectEdition;

public class AdminProjectEdit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view_form = "/WEB-INF/admin/project_edit.jsp";
	public final static String path_success = "projects_list";
	
	public final static String SESSION = "session_user";
	
	public final static String PROJECT = "project";
	public final static String FORM = "form";
	
	private ProjectDAO projectDAO;
	
	@Override
	public void init() throws ServletException {
		projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		Project project;
		if(user_session == null || user_session.getRightLevel() != 2) {
			resp.sendError(401);
		} else {
			project = (Project) req.getAttribute(PROJECT);
			req.setAttribute(PROJECT, project);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Project project;
		
		AdminProjectEdition form = new AdminProjectEdition(projectDAO);
		
		project = form.editProject(req);
		
		if (form.getErrors().isEmpty())
			resp.sendRedirect(resp.encodeRedirectURL(path_success)); 
		else {
			req.setAttribute(PROJECT, project);
			req.setAttribute(FORM, form);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
}
