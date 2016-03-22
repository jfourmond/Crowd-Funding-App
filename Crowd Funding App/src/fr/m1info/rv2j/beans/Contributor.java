package fr.m1info.rv2j.beans;

public class Contributor {
	private int id;
	private int projectID;
	// private int compensationID;
	private int donation;
	
	/**	GETTERS	**/
	public int getID() { return id; }
	
	public int getProjectID() { return projectID; }
	
	public int getDonation() { return donation; }
	
	/**	SETTERS	**/
	public void setID(int id) { this.id = id; }
	
	public void setProjectID(int projectID) { this.projectID = projectID; }
	
	public void setDonation(int donation) { this.donation = donation; }
	
	@Override
	public String toString() {
		String ch = "Contribution : ";
		ch += "\tID : " + id;
		ch += "\tProjet : " + projectID;
		ch += "\tDons : " + donation;
		return ch;
	}
}
