package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.dao.DAOException;
import fr.m1info.rv2j.dao.ProjectDAO;
import fr.m1info.rv2j.dao.UserDAO;

public class AdminProjectCreation extends Forms {
	public final static String NAME_FIELD = "name";
	public final static String USER_FIELD = "id_user";
	public final static String PRESENTATION_FIELD = "presentation";
	public final static String GOAL_FIELD = "goal";
	
	private ProjectDAO projectDAO;
	private UserDAO userDAO;
	
	/**	CONSTRUCTEURS	**/
	public AdminProjectCreation() {
		super();
	}
	
	public AdminProjectCreation(ProjectDAO projectDAO, UserDAO userDAO) {
		super();
		this.projectDAO = projectDAO;
		this.userDAO = userDAO;
	}
	
	public Project createProject(HttpServletRequest request) {
		Project project = new Project();
		
		String name = getFieldValue(request, NAME_FIELD);
		String user = getFieldValue(request, USER_FIELD);
		String presentation = getFieldValue(request, PRESENTATION_FIELD);
		String goal = getFieldValue(request, GOAL_FIELD);
		
		try {
			nameProcessing(name, project);
			userProcessing(user, project);
			presentationProcessing(presentation, project);
			goalProcessing(goal, project);
			
			if (errors.isEmpty()) {
				projectDAO.create(project);
				result = "Succès de la création du projet.";
			} else
				result = "Échec de la création du projet.";
		} catch(DAOException E) {
			result = "Échec de la création : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}
		return project;
	}
	
	private void nameProcessing(String name, Project project) {
		try {
			checkName(name);
			project.setName(name);
		} catch(FormValidationException E) {
			E.printStackTrace();
			addErrors(NAME_FIELD, E.getMessage());
		}
	}
	
	private void checkName(String name) throws FormValidationException {
		if(name == null) 
			throw new FormValidationException("Veuillez saisir un nom");
	}
	
	private void userProcessing(String user, Project project) {
		try {
			checkUser(user);
			project.setAuthorID(Integer.parseInt(user));
		} catch(FormValidationException E) {
			E.printStackTrace();
			addErrors(USER_FIELD, E.getMessage());
		}
	}
	
	private void checkUser(String user) throws FormValidationException {
		if(user != null) {
			if(userDAO.findByID(user) == null)
				throw new FormValidationException("L'id de l'utilisateur n'existe pas.");
		} else throw new FormValidationException("Veuillez saisir un id d'utilisateur.");
	}
	
	private void presentationProcessing(String presentation, Project project) {
		try {
			checkPresentation(presentation);
			project.setPresentation(presentation);
		} catch (FormValidationException E) {
			E.printStackTrace();
			addErrors(PRESENTATION_FIELD, E.getMessage());
		}
	}
	
	private void checkPresentation(String presentation) throws FormValidationException {
		if(presentation == null)
			throw new FormValidationException("Veuillez saisir une présentation");
	}
	
	private void goalProcessing(String goal, Project project) {
		try {
			checkGoal(goal);
			project.setGoal(Integer.parseInt(goal));
		} catch (FormValidationException E) {
			addErrors(GOAL_FIELD, E.getMessage());
		}
	}
	
	private void checkGoal(String goal) throws FormValidationException {
		if(goal == null)
			throw new FormValidationException("Veuillez saisir un montant objectif");
	}
}
