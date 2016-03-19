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
	private int right_level;
	
	/* Constructeurs */
	public User() { 
		inscription_date = new Date(System.currentTimeMillis());
	};
	
	public User(String name, String pw, String email) {
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.inscription_date = new Date(System.currentTimeMillis());
	}
	
	public User(String name, String pw, String email, Date date){
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
	
	public Date getInscriptionDate() { return inscription_date; }
	
	public int getRight_level() { return right_level; }
	
	/*	SETTERS	*/
	public void setID(int id) { this.id = id; }
	
	public void setName(String name) { this.name = name; }
	
	public void setPassword(String pw) { this.pw = pw; }
	
	public void setEmail(String email) { this.email = email; }
	
	public void setInscriptionDate(Date date) { this.inscription_date = date; }
	
	public void setRightLevel(int level) { this.right_level = level; }
}
