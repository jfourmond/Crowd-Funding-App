package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class EncodingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String ENCODING = "encoding"; //key for encoding.
	private String encoding;

	public void init(ServletConfig servletConfig) throws ServletException {
		this.encoding = servletConfig.getInitParameter(ENCODING);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset="+encoding);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset="+encoding);
	}
}
