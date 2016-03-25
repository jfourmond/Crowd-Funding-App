package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.ProjectDAO;

public class Home extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";

	private ProjectDAO projectDAO;
	private List<Project> projects;
	
	public final static String view = "/home.jsp";
	public final static String PROJECTS = "projects";
	public final static String PROJECT = "project";
	
	public void init() throws ServletException {
		this.projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		projects = projectDAO.getAllProjects();
		req.setAttribute(PROJECTS, projects);
		this.getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
}
