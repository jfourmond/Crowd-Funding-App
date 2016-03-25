package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Commentary;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.CommentaryDAO;
import fr.m1info.rv2j.dao.DAOException;

public class CommentaryCreation extends Forms {
	public final static String COMMENTARY_FIELD = "comment";
	public final static String PROJECT_ID = "id";
	
	public final static String SESSION = "session_user";
	
	private CommentaryDAO commentaryDAO;
	
	/**	CONSTRUCTEURS	**/
	public CommentaryCreation() {
		super();
	}
	
	public CommentaryCreation(CommentaryDAO commentaryDAO) {
		super();
		this.commentaryDAO = commentaryDAO;
	}
	
	public Commentary createCommentary(HttpServletRequest request) {
		Commentary commentary = new Commentary();
		
		HttpSession session = request.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		String comment = getFieldValue(request, COMMENTARY_FIELD);
		String project_id = getFieldValue(request, PROJECT_ID);
		
		try {
			commentary.setAuthorID(user_session.getID());
			commentary.setProjectID(Integer.parseInt(project_id));
			commentProcessing(comment, commentary);
						
			if (errors.isEmpty()) {
				commentaryDAO.create(commentary);
				result = "Succès de la création du commentaire.";
			} else
				result = "Échec de la création du commentaire.";
		} catch(DAOException E) {
			result = "Échec de la création : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}

		return commentary;
	}
	
	private void commentProcessing(String comment, Commentary commentary) {
		try {
			checkComment(comment);
			commentary.setText(comment);
		} catch (FormValidationException E) {
			addErrors(COMMENTARY_FIELD, E.getMessage());
		}
	}
	
	private void checkComment(String comment) throws FormValidationException {
		if(comment != null) {
			if(comment.length() < 5)
				throw new FormValidationException("Veuillez saisir un commentaire d'au moins 5 caractères.");
		} else
			throw new FormValidationException("Veuillez saisir un montant objectif");
	}
}
