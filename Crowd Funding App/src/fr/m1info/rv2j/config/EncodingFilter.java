package fr.m1info.rv2j.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	public static final String ENCODING = "encoding"; //key for encoding.
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter(ENCODING);
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset="+encoding);
		filterChain.doFilter(req, resp);
		
	}
		
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
