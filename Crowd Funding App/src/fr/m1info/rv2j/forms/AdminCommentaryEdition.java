package fr.m1info.rv2j.forms;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.Commentary;
import fr.m1info.rv2j.dao.CommentaryDAO;
import fr.m1info.rv2j.dao.DAOException;

public class AdminCommentaryEdition extends Forms{
	public final static String ID_FIELD = "id";
	public final static String TEXT_FIELD = "text";
	
	private CommentaryDAO commentaryDAO;
	
	/**	CONSTRUCTEURS	**/
	public AdminCommentaryEdition() {
		super();
	}
	
	public AdminCommentaryEdition(CommentaryDAO commentaryDAO) {
		super();
		this.commentaryDAO = commentaryDAO;
	}
	
	public Commentary editCommentary(HttpServletRequest request) {
		Commentary commentary = new Commentary();
		
		String id = getFieldValue(request, ID_FIELD);
		String text = getFieldValue(request, TEXT_FIELD);
		
		try {
			commentary.setID(Integer.parseInt(id));
			textProcessing(text, commentary);
			lastUpdateProcessing(commentary);
			
			if (errors.isEmpty()) {
				commentaryDAO.update(id, commentary);
				result = "Succès de l'édition du commentaire.";
			} else
				result = "Échec de l'édition du commentaire.";
		} catch(DAOException E) {
			result = "Échec de l'édition : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}

		return commentary;
	}
	
	private void textProcessing(String text, Commentary commentary) {
		try {
			checkText(text);
			commentary.setText(text);
		} catch (FormValidationException E) {
			E.printStackTrace();
			addErrors(TEXT_FIELD, E.getMessage());
		}
	}
	
	private void checkText(String text) throws FormValidationException {
		if(text != null) {
			if(text.length() < 5)
				throw new FormValidationException("Merci d'entrer une présentation d'au moins 10 caractères.");
		}	else
			throw new FormValidationException("Merci d'entrer une présentation d'au moins 10 caractères.");
	}
	
	private void lastUpdateProcessing(Commentary commentary) {
			commentary.setLastUpdate(new Date(System.currentTimeMillis()));
	}
}
