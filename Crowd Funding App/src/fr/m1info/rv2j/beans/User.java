package fr.m1info.rv2j.beans;

import java.sql.Date;

/**
 * Représentation d'un Utilisateur
 */
public class User {
	private int id;
	private String name;
	private String pw;
	private String email;
	private Date inscription_date;
	
	/*	GETTERS	*/
	public int getId() { return id; }
	
	public String getName() { return name; }
	
	public String getPassword() { return pw; }
	
	public String getEmail() { return email; }
	
	public Date getInscriptionDate() { return inscription_date; }
	
	/*	SETTERS	*/
	public void setID(int id) { this.id = id; }
	
	public void setName(String name) { this.name = name; }
	
	public void setPassword(String pw) { this.pw = pw; }
	
	public void setEmail(String email) { this.email = email; }
	
	public void setInscriptionDate(Date date) { this.inscription_date = date; }
}
