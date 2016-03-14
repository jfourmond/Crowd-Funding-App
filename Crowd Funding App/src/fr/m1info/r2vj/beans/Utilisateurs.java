package fr.m1info.r2vj.beans;

public class Utilisateurs {
	/* champs */
	private String nom;
	private String mdp;
	private String email;
	
	/* getters */
	public String getNom(){
		return nom;
	}
	
	public String getMdp(){
		return mdp;
	}
	
	public String getEmail(){
		return email;
	}
	
	/* setters */
	public void setNom(String N){
		email=N;
	}
	
	public void setMdp(String M){
		mdp=M;
	}
	
	public void setEmail(String E){
		email=E;
	}
}
