package fr.m1info.rv2j.beans;

import org.joda.time.DateTime;

/**
 * Représentation d'un Utilisateur
 */
public class User {
	private int id;
	private String name;
	private String pw;
	private String email;
	private DateTime inscription_date;
	
	/* Constructeurs */
	public User() { inscription_date = new DateTime(); };
	
	public User(String name, String pw, String email) {
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.inscription_date = new DateTime();
	}
	
	public User(String name, String pw, String email, DateTime date){
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.inscription_date=date;
	}
	
	/*	GETTERS	*/
	public int getID() { return id; }
	
	public String getName() { return name; }
	
	public String getPassword() { return pw; }
	
	public String getEmail() { return email; }
	
	public DateTime getInscriptionDate() { return inscription_date; }
	
	/*	SETTERS	*/
	public void setID(int id) { this.id = id; }
	
	public void setName(String name) { this.name = name; }
	
	public void setPassword(String pw) { this.pw = pw; }
	
	public void setEmail(String email) { this.email = email; }
	
	public void setInscriptionDate(DateTime date) { this.inscription_date = date; }
}
