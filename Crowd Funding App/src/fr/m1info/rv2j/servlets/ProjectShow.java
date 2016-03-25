package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Commentary;
import fr.m1info.rv2j.beans.Contribution;
import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.CommentaryDAO;
import fr.m1info.rv2j.dao.ContributionDAO;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.ProjectDAO;
import fr.m1info.rv2j.dao.UserDAO;
import fr.m1info.rv2j.forms.CommentaryCreation;

public class ProjectShow extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view = "/WEB-INF/project.jsp";
	public final static String redirection_path = "projects";
	
	
	public final static String SESSION = "session_user";
	
	public final static String AUTHOR = "author";
	public final static String PROJECT = "project";
	public final static String USERS = "users";
	public final static String CONTRIBUTIONS = "contributions";
	public final static String DONATION = "donation_progress";
	public final static String COMMENTARIES = "commentaries";
	
	public final static String ID = "id";
	public final static String FORM = "form";
	public final static String COMMENTARY = "commentary";
	
	private ProjectDAO projectDAO;
	private UserDAO userDAO;
	private ContributionDAO contributionDAO;
	private CommentaryDAO commentaryDAO;
	
	private Project project;
	private User user;
	private Map<Integer, User> users;
	private List<Contribution> contributions;
	private List<Commentary> commentaries;
	private int donation_total;
	
	@Override
	public void init() throws ServletException {
		projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
		userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
		contributionDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getContributionDao();
		commentaryDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getCommentaryDao();
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
			if(id_project == null)
				resp.sendRedirect(resp.encodeRedirectURL(redirection_path)); 
			else {
				project = projectDAO.findByID(id_project);
				user = userDAO.findByID(String.valueOf(project.getAuthorID()));
				users = userDAO.mapUsers();
				contributions = contributionDAO.findByProjectID(id_project);
				donation_total = contributionDAO.getTotalContributionsToProject(id_project);
				commentaries = commentaryDAO.findByProjectID(id_project);
				req.setAttribute(AUTHOR, user);
				req.setAttribute(PROJECT, project);
				req.setAttribute(USERS, users);
				req.setAttribute(CONTRIBUTIONS, contributions);
				req.setAttribute(DONATION, donation_total);
				req.setAttribute(COMMENTARIES, commentaries);
				this.getServletContext().getRequestDispatcher(view).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentaryCreation form = new CommentaryCreation(commentaryDAO);
		
		Commentary commentary = form.createCommentary(req);

		req.setAttribute(ID, project.getID());
		req.setAttribute(FORM, form);
		
		if (form.getErrors().isEmpty())
			this.doGet(req, resp);
		else {
			req.setAttribute(COMMENTARY, commentary);
			this.getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
}
