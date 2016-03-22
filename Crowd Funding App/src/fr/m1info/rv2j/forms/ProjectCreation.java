package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOException;
import fr.m1info.rv2j.dao.ProjectDAO;

public class ProjectCreation extends Forms {
	public final static String NAME_FIELD = "name";
	public final static String PRESENTATION_FIELD = "presentation";
	public final static String GOAL_FIELD = "goal";
	
	public final static String SESSION = "session_user";
	
	private ProjectDAO projectDAO;
	
	/**	CONSTRUCTEURS	**/
	public ProjectCreation() {
		super();
	}
	
	public ProjectCreation(ProjectDAO projectDAO) {
		super();
		this.projectDAO = projectDAO;
	}
	
	public Project createProject(HttpServletRequest request) {
		Project project = new Project();
		
		HttpSession session = request.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		String name = getFieldValue(request, NAME_FIELD);
		String presentation = getFieldValue(request, PRESENTATION_FIELD);
		String goal = getFieldValue(request, GOAL_FIELD);
		
		try {
			nameProcessing(name, project);
			presentationProcessing(presentation, project);
			goalProcessing(goal, project);
			project.setAuthorID(user_session.getID());
						
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
		if(name != null) {
			if(name.length() < 5)
				throw new FormValidationException("Le nom de projet doit contenir au moins 5 caractères.");
			else if(projectDAO.findByName(name) != null)
				throw new FormValidationException("Le nom de projet est déjà utilisé.");
		} else
			throw new FormValidationException("Merci d'entrer un nom de projet.");
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
		if(presentation != null) {
			if(presentation.length() < 20)
				throw new FormValidationException("Le nom du projet doit contenir au moins 20 caractères.");
		} else throw new FormValidationException("Veuillez saisir une présentation");
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
