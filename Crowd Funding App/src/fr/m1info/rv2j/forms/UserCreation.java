package fr.m1info.rv2j.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.User;

public class UserCreation {
	public final static String USERNAME_FIELD = "username";
	public final static String EMAIL_FIELD = "email";
	public final static String PW_FIELD = "password";
	public final static String PW_CONF_FIELD = "password_conf";
	
	private String result;
	private Map<String, String> errors;
	
	/**	CONSTRUCTEURS	**/
	public UserCreation() {
		errors = new HashMap<String, String>();
	}
	
	/**	GETTERS	**/
	public String getResult() { return result; }
	
	public Map<String, String> getErrors() { return errors; }
	
	private String getFieldValue(HttpServletRequest request, String field) {
		String value = request.getParameter(field);
		if(value == null || value.trim().length() == 0)
			return null;
		else
			return value;
	}
	
	private void addErrors(String field, String message) {
		errors.put(field, message);
	}
	
	public User createUser(HttpServletRequest request) {
		String name = getFieldValue(request, USERNAME_FIELD);
		String email = getFieldValue(request, EMAIL_FIELD);
		String pw = getFieldValue(request, PW_FIELD);
		String pw_conf = getFieldValue(request, PW_CONF_FIELD);
		
		User user = new User();
		
		try {
			checkName(name);
			user.setName(name);
		} catch (Exception E) {
			addErrors(USERNAME_FIELD, E.getMessage());
		}
		try {
			checkEmail(EMAIL_FIELD);
			user.setEmail(email);
		} catch (Exception E) {
			addErrors(EMAIL_FIELD, E.getMessage());
		}
		try {
			checkPassword(pw, pw_conf);
			user.setPassword(pw);
		} catch (Exception E) {
			addErrors(PW_FIELD, E.getMessage());
		}

		if (errors.isEmpty())
			result = "Succès de la création du client.";
		else
			result = "Échec de la création du client.";
		
		return user;
	}
	
	private void checkName(String name) throws Exception {
		if(name != null) {
			if(name.length() < 5)
				throw new Exception("Le nom d'utilisateur doit contenir au moins 5 caractères.");
		} else
			throw new Exception("Merci d'entrer un nom d'utilisateur.");
	}
	
	private void checkEmail(String email) throws Exception {
		if(email == null)
			throw new Exception("Merci d'entrer une adresse email.");
	}
	
	private void checkPassword(String pw, String pw_conf) throws Exception {
		if(pw != null && pw_conf != null) {
			if(!pw.equals(pw_conf))
				throw new Exception("Les mots de passe sont différentes");
		} else throw new Exception("Merci d'entrer un mot de passe.");
	}
}
