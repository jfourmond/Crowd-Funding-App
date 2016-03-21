package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.dao.DAOException;
import fr.m1info.rv2j.dao.ProjectDAO;

public class ProjectCreation extends Forms {
	public final static String AUTHOR_FIELD = "author";
	public final static String NAME_FIELD = "name";
	public final static String PRESENTATION_FIELD = "presentation";
	public final static String GOAL_FIELD = "goal";
	
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
		
		String author = getFieldValue(request, AUTHOR_FIELD);
		String name = getFieldValue(request, NAME_FIELD);
		String presentation = getFieldValue(request, PRESENTATION_FIELD);
		String goal = getFieldValue(request, GOAL_FIELD);
		
		try {
			authorProcessing(author, project);
			nameProcessing(name, project);
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
	
	private void authorProcessing(String name, Project project) {
		try {
			checkName(name);
			project.setName(name);
		} catch (FormValidationException E) {
			addErrors(NAME_FIELD, E.getMessage());
		}
	}
	
	private void checkAuthor(String author) throws FormValidationException {
		if(author != null) {
			if(author.length() < 5)
				throw new FormValidationException("Le nom de l'auteur doit contenir au moins 5 caractères.");
		} else
			throw new FormValidationException("Merci d'entrer un nom d'auteur.");
	}
	
	private void nameProcessing(String author, Project project) {
		try {
			checkAuthor(author);
			project.setAuthor(author);
		} catch (FormValidationException E) {
			addErrors(AUTHOR_FIELD, E.getMessage());
		}
	}
	
	private void checkName(String name) throws FormValidationException {
		if(name != null) {
			if(name.length() < 5)
				throw new FormValidationException("Le nom de projet doit contenir au moins 5 caractères.");
			else if(projectDAO.findByNAME(name) != null)
				throw new FormValidationException("Le nom de projet est déjà utilisé.");
		} else
			throw new FormValidationException("Merci d'entrer un nom de projet.");
	}

}
