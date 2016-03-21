package fr.m1info.rv2j.forms;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.dao.DAOException;
import fr.m1info.rv2j.dao.ProjectDAO;

public class AdminProjectEdition extends Forms {
	public final static String ID_FIELD = "id";
	public final static String PROJECTNAME_FIELD = "projectname";
	public final static String PRESENTATION_FIELD = "presentation";
	public final static String GOAL_FIELD = "goal";
	
	private ProjectDAO projectDAO;
	
	/**	CONSTRUCTEURS	**/
	public AdminProjectEdition() {
		super();
	}
	
	public AdminProjectEdition(ProjectDAO projectDAO) {
		super();
		this.projectDAO = projectDAO;
	}
	
	public Project editProject(HttpServletRequest request) {
		Project project = new Project();
		
		String id = getFieldValue(request, ID_FIELD);
		String projectname = getFieldValue(request, PROJECTNAME_FIELD);
		String presentation = getFieldValue(request, PRESENTATION_FIELD);
		String goal = getFieldValue(request, GOAL_FIELD);
		
		try {
			project.setID(Integer.parseInt(id));
			nameProcessing(projectname, project);
			presentationProcessing(presentation, project);
			goalProcessing(goal, project);
			last_updateProcessing(project);
			
			if (errors.isEmpty()) {
				projectDAO.update(id, project);
				result = "Succès de l'édition du projet.";
			} else
				result = "Échec de l'édition du projet.";
		} catch(DAOException E) {
			result = "Échec de l'édition : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}

		return project;
	}
	
	private void nameProcessing(String name, Project project) {
		try {
			checkName(name);
			project.setName(name);
		} catch (FormValidationException E) {
			addErrors(PROJECTNAME_FIELD, E.getMessage());
		}
	}
	
	private void checkName(String name) throws FormValidationException {
		if(name == null)
			throw new FormValidationException("Merci d'entrer un nom d'utilisateur.");
	}
	
	private void presentationProcessing(String presentation, Project project) {
		try {
			checkPresentation(presentation);
			project.setPresentation(presentation);
		} catch (FormValidationException E) {
			addErrors(PRESENTATION_FIELD, E.getMessage());
		}
	}
	
	private void checkPresentation(String presentation) throws FormValidationException {
		if(presentation != null) {
			if(presentation.length() < 10)
				throw new FormValidationException("Merci d'entrer une présentation d'au moins 10 caractères.");
		}	else
			throw new FormValidationException("Merci d'entrer une présentation d'au moins 10 caractères.");
	}
	
	private void goalProcessing(String goal, Project project) {
		try {
			checkGoal(goal);
			project.setGoal(Integer.parseInt(goal));
		} catch (FormValidationException E) {
			addErrors(GOAL_FIELD, E.getMessage());
		}
	}
	
	private void checkGoal(String pw) throws FormValidationException {
		if(pw == null)
			throw new FormValidationException("Merci d'entrer un montant objectif.");
	}
	
	private void last_updateProcessing(Project project) {
			project.setLastUpdateDate(new Date(System.currentTimeMillis()));
	}
}
