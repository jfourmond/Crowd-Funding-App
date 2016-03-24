package fr.m1info.rv2j.beans;

import java.sql.Date;

/**
 * Représentation d'un commentaire
 */
public class Commentary {
	private int id;
	private String text;
	private int project_id;
	private int author_id;
	private Date creation_date;
	private Date last_update;
	
	/*	GETTERS	*/
	public int getID() { return id; }
	
	public String getText() { return text; }
	
	public int getProjectID() { return project_id; }
	
	public int getAuthorID() { return author_id; }
	
	public Date getCreationDate() { return creation_date; }
	
	public Date getLastUpdate() { return last_update; }
	
	/*	SETTERS	*/
	public void setID(int id) { this.id = id; }
	
	public void setText(String text) { this.text = text; }
	
	public void setProjectID(int id) { this.project_id = id; }
	
	public void setAuthorID(int id) { this.author_id = id; }
	
	public void setCreationDate(Date date ) { this.creation_date = date; }
	
	public void setLastUpdate(Date date) { this.last_update = date; }
}
