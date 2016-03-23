package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;

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

public class MyContributions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view = "/WEB-INF/my_contributions.jsp";
	
	public final static String SESSION = "session_user";
	
	public final static String CONTRIBUTIONS = "contributions";
	public final static String PROJECT = "project";
	
	private ContributionDAO contributionDAO;
	private ProjectDAO projectDAO;
	
	private List<Project> my_projects;
	private List<Contribution> my_contributions;
	
	@Override
	public void init() throws ServletException {
		this.projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
		this.contributionDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getContributionDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		if(user_session == null || user_session.getRightLevel() == 0) {
			resp.sendError(401);
		} else {
			my_contributions = contributionDAO.findByAuthorID(String.valueOf(user_session.getID()));
			my_projects = projectDAO.findByAuthorID(String.valueOf(user_session.getID()));
			req.setAttribute(CONTRIBUTIONS, my_contributions);
			this.getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
