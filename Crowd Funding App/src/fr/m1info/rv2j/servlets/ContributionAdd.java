package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Contribution;
import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.ContributionDAO;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.ProjectDAO;
import fr.m1info.rv2j.forms.ContributionCreation;

public class ContributionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view_form = "/WEB-INF/contribution_add.jsp";
	public final static String path_success = "project";
	
	public final static String SESSION = "session_user";
	
	public final static String PROJECT = "project";
	public final static String CONTRIBUTION = "contribution";
	public final static String FORM = "form";
	
	public final static String ID = "id";
	
	private ProjectDAO projectDAO;
	private ContributionDAO contributionDAO;
	
	private Project project;
	
	@Override
	public void init() throws ServletException {
		projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
		contributionDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getContributionDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		String id_project;
		
		if(user_session == null || user_session.getRightLevel() == 0) {
			resp.sendError(401);
		} else {
			id_project = (String) req.getParameter(ID);
			project = projectDAO.findByID(id_project);
			req.setAttribute(PROJECT, project);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contribution contribution;
		
		ContributionCreation form = new ContributionCreation(contributionDAO);
		
		contribution = form.createContribution(req);
		
		if (form.getErrors().isEmpty()) {
			resp.sendRedirect(resp.encodeRedirectURL(path_success+"?id="+project.getID())); 
		} else {
			req.setAttribute(CONTRIBUTION, contribution);
			req.setAttribute(FORM, form);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
}
