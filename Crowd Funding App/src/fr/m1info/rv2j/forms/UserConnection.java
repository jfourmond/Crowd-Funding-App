package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.UserDAO;

public class UserConnection extends Forms {
	public final static String USERNAME_FIELD = "username";
	public final static String PW_FIELD = "password";
	
	private UserDAO userDAO;
	
	private String username;
	
	/**	CONSTRUCTEURS	**/
	public UserConnection() {
		super();
	}
	
	public UserConnection(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	
	/**	SETTERS	**/
	public String getUsername() {
		return username;
	}
	
	public User connectUser(HttpServletRequest request) {
		User user = null;
		
		username = getFieldValue(request, USERNAME_FIELD);
		String pw = getFieldValue(request, PW_FIELD);
		
		user = processUser(username, pw);
		
		if(user!=null)
			result = "Connexion réussie";
		else
			addErrors(USERNAME_FIELD, "Identifiant ou mot de passe incorrect");
		
		return user;
	}
	
	private User processUser(String name, String pw) {
		User user = userDAO.findByName(name);
		if(user == null)
			return user;
		else if(user.getPassword().equals(pw))
			return user;
		else return null;
	}
}
