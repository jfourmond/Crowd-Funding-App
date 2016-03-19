package fr.m1info.rv2j.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class Forms {
	protected String result;
	protected Map<String, String> errors;
	
	/** Constructeur	**/
	protected Forms() {
		errors = new HashMap<String, String>();
	}
	
	/**	SETTERS	**/
	public String getResult() { return result; }
	
	public Map<String, String> getErrors() { return errors; }
	
	protected String getFieldValue(HttpServletRequest request, String field) {
		String value = request.getParameter(field);
		if(value == null || value.trim().length() == 0)
			return null;
		else
			return value;
	}
	
	protected void addErrors(String field, String message) {
		errors.put(field, message);
	}
}
