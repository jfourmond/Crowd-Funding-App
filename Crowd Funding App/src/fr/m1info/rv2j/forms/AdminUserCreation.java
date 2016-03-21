package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOException;
import fr.m1info.rv2j.dao.UserDAO;

public class AdminUserCreation extends Forms {
	public final static String USERNAME_FIELD = "username";
	public final static String EMAIL_FIELD = "email";
	public final static String PW_FIELD = "password";
	public final static String RIGHT_FIELD = "right_level";
	
	private UserDAO userDAO;
	
	/**	CONSTRUCTEURS	**/
	public AdminUserCreation() {
		super();
	}
	
	public AdminUserCreation(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	
	public User createUser(HttpServletRequest request) {
		User user = new User();
		
		String name = getFieldValue(request, USERNAME_FIELD);
		String email = getFieldValue(request, EMAIL_FIELD);
		String pw = getFieldValue(request, PW_FIELD);
		String right = getFieldValue(request, RIGHT_FIELD);
		
		try {
			nameProcessing(name, user);
			emailProcessing(email, user);
			passwordProcessing(pw, user);
			rightProcessing(right, user);
			
			if (errors.isEmpty()) {
				userDAO.create(user);
				result = "Succès de la création du client.";
			} else
				result = "Échec de la création du client.";
		} catch(DAOException E) {
			result = "Échec de la création : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}

		return user;
	}
	
	private void nameProcessing(String name, User user) {
		try {
			checkName(name);
			user.setName(name);
		} catch (FormValidationException E) {
			addErrors(USERNAME_FIELD, E.getMessage());
		}
	}
	
	private void checkName(String name) throws FormValidationException {
		if(name != null) {
			if(name.length() < 5)
				throw new FormValidationException("Le nom d'utilisateur doit contenir au moins 5 caractères.");
			else if(userDAO.findByName(name) != null)
				throw new FormValidationException("Le nom d'utilisateur est déjà utilisé.");
		} else
			throw new FormValidationException("Merci d'entrer un nom d'utilisateur.");
	}
	
	private void emailProcessing(String email, User user) {
		try {
			checkEmail(email);
			user.setEmail(email);
		} catch (FormValidationException E) {
			addErrors(EMAIL_FIELD, E.getMessage());
		}
	}
	
	private void checkEmail(String email) throws FormValidationException {
		if(email != null) {
			if(!email.matches("(\\w)+@(\\w)+\\.(\\w)+"))
				throw new FormValidationException("Merci d'entrer une adresse email valide.");
			else if(userDAO.findByEmail(email) != null)
				throw new FormValidationException("L'adresse email est déjà utilisée.");
		}	else
			throw new FormValidationException("Merci d'entrer une adresse email.");
	}
	
	private void passwordProcessing(String pw, User user) {
		try {
			checkPassword(pw);
			user.setPassword(pw);
		} catch (FormValidationException E) {
			addErrors(PW_FIELD, E.getMessage());
		}
	}
	
	private void checkPassword(String pw) throws FormValidationException {
		if(pw ==null) 
			throw new FormValidationException("Merci d'entrer un mot de passe.");
	}
	
	private void rightProcessing(String right, User user) {
		try {
			checkRight(right);
			user.setRightLevel(Integer.parseInt(right));
		} catch (FormValidationException E) {
			addErrors(RIGHT_FIELD, E.getMessage());
		}
	}
	
	private void checkRight(String right) throws FormValidationException {
		if(right == null)
			throw new FormValidationException("Merci d'entrer un niveau de droit.");
		else {
			int right_int = Integer.parseInt(right);
			if(right_int != 1 && right_int != 2)
				throw new FormValidationException("Merci d'entrer un niveau de droit valide (1|2)");
		}
	}
}
