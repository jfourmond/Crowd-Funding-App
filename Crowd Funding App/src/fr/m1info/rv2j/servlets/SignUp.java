package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m1info.rv2j.bd.bd;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.forms.UserCreation;

public class SignUp extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public final static String view_form = "/WEB-INF/signup.jsp";
	public final static String view_success = "/WEB-INF/login.jsp";
	
	public final static String USER = "user";
	public final static String FORM = "form";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(view_form).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserCreation form = new UserCreation();

		User user = form.createUser(req);

		req.setAttribute(USER, user);
		req.setAttribute(FORM, form);

		// TODO Ajouter utilisateur à la base
		/*bd bdUsr = new bd("root", "root");
		bdUsr.dbConnect();
		bdUsr.reqInsUser(user);
		bdUsr.dbClose();*/
		
		if ( form.getErrors().isEmpty() )
			this.getServletContext().getRequestDispatcher( view_success).forward(req, resp);
		else
			this.getServletContext().getRequestDispatcher( view_form ).forward( req, resp);
	}
}
