package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.CommentaryDAO;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.forms.AdminCommentaryEdition;

public class AdminCommentaryEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view_form = "/WEB-INF/admin/commentary_edit.jsp";
	public final static String path_success = "commentaries_list";
	
	public final static String SESSION = "session_user";
	
	public final static String COMMENTARY = "commentary";
	public final static String FORM = "form";
	
	private CommentaryDAO commentaryDAO;
	
	@Override
	public void init() throws ServletException {
		commentaryDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getCommentaryDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		Commentary commentary;
		if(user_session == null || user_session.getRightLevel() != 2) {
			resp.sendError(401);
		} else {
			commentary = (User) req.getAttribute(COMMENTARY);
			req.setAttribute(COMMENTARY, commentary);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user;
		
		AdminCommentaryEdition form = new AdminCommentaryEdition(commentaryDAO);
		
		form.editCommentary(req);
		
		if (form.getErrors().isEmpty())
			resp.sendRedirect(resp.encodeRedirectURL(path_success));
		else {
			req.setAttribute(COMMENTARY, commentary);
			req.setAttribute(FORM, form);
			this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
		}
	}
	
}
