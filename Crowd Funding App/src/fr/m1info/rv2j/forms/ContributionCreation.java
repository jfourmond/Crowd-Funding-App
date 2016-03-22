package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.Contribution;
import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.ContributionDAO;
import fr.m1info.rv2j.dao.DAOException;

public class ContributionCreation extends Forms {
	public final static String DONATION_FIELD = "donation";
	public final static String PROJECT_ID = "id";
	
	public final static String SESSION = "session_user";
	
	private ContributionDAO contributionDAO;
	
	/**	CONSTRUCTEURS	**/
	public ContributionCreation() {
		super();
	}
	
	public ContributionCreation(ContributionDAO contributionDAO) {
		super();
		this.contributionDAO = contributionDAO;
	}
	
	public Contribution createContribution(HttpServletRequest request) {
		Contribution contribution = new Contribution();
		
		HttpSession session = request.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		String donation = getFieldValue(request, DONATION_FIELD);
		String project_id = getFieldValue(request, PROJECT_ID);
		try {
			contribution.setUserID(user_session.getID());
			contribution.setProjectID(Integer.parseInt(project_id));
			donationProcessing(donation, contribution);
						
			if (errors.isEmpty()) {
				contributionDAO.create(contribution);
				result = "Succès de la création de la contribution.";
			} else
				result = "Échec de la création du contribution.";
		} catch(DAOException E) {
			result = "Échec de la création : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}

		return contribution;
	}
	
	private void donationProcessing(String donation, Contribution contribution) {
		try {
			checkDonation(donation);
			contribution.setDonation(Integer.parseInt(donation));
		} catch (FormValidationException E) {
			addErrors(DONATION_FIELD, E.getMessage());
		}
	}
	
	private void checkDonation(String donation) throws FormValidationException {
		if(donation == null)
			throw new FormValidationException("Veuillez saisir un montant objectif");
	}
}
