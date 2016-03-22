package fr.m1info.rv2j.beans;

import java.sql.Date;

public class Contribution {
	private int userID;
	private int projectID;
	// private int compensationID;
	private int donation;
	private Date creation_date;
	
	/**	CONSTRUCTEUR	**/
	public Contribution() {
		creation_date = new Date(System.currentTimeMillis());
	}
	
	/**	GETTERS	**/
	public int getUserID() { return userID; }
	
	public int getProjectID() { return projectID; }
	
	public int getDonation() { return donation; }
	
	public Date getCreationDate() { return creation_date; }
	
	/**	SETTERS	**/
	public void setUserID(int id) { this.userID = id; }
	
	public void setProjectID(int projectID) { this.projectID = projectID; }
	
	public void setDonation(int donation) { this.donation = donation; }
	
	public void setCreationDate(Date creation_date) { this.creation_date = creation_date; }
	
	@Override
	public String toString() {
		String ch = "Contribution : ";
		ch += "\tUtilisateur : " + userID;
		ch += "\tProjet : " + projectID;
		ch += "\tDons : " + donation;
		return ch;
	}
}
