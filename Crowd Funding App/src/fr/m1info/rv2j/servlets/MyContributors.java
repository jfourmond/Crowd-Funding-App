package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import fr.m1info.rv2j.dao.UserDAO;

public class MyContributors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view = "/WEB-INF/my_contributors.jsp";
	
	public final static String SESSION = "session_user";
	
	public final static String USERS = "users";
	public final static String CONTRIBUTIONS = "contributions";
	public final static String PROJECTS = "projects";
	

	private UserDAO userDAO;
	private ContributionDAO contributionDAO;
	private ProjectDAO projectDAO;
	

	private Map<Integer, User> users;
	private List<Contribution> contributions;
	private List<Project> my_projects;
	
	@Override
	public void init() throws ServletException {
		this.userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
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
			users = userDAO.mapUsers();
			contributions = contributionDAO.getAllContributions();
			my_projects = projectDAO.findByAuthorID(Integer.toString(user_session.getID()));
			req.setAttribute(USERS, users);
			req.setAttribute(CONTRIBUTIONS, contributions);
			req.setAttribute(PROJECTS, my_projects);
			this.getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
