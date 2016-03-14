package fr.m1info.rv2j.beans;

public class User {
	/* champs */
	private String name;
	private String pw;
	private String email;
	
	/* getters */
	public String getName() { return name; }
	
	public String getPassword() { return pw; }
	
	public String getEmail() { return email; }
	
	/* setters */
	public void setName(String name) { this.name = name; };
	
	public void setPassword(String pw) { this.pw = pw; };
	
	public void setEmail(String email) { this.email = email; }
}
