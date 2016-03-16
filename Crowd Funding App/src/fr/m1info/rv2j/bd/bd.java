package fr.m1info.rv2j.bd;

import java.io.*;
import java.sql.*;
import java.util.*;

import fr.m1info.rv2j.beans.Compensation;
import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.beans.User;

public class bd {
	//variables
	private Connection conn = null;
    private Statement stmt = null;
	private String url = "jdbc:mysql://localhost/fr_m1info_rv2j";
	private String user;
	private String pw;
		   
	//constructeur
	public bd(String usr, String p){
		user=usr;
		pw=p;
	}
	
	//methodes
	
	//se connecte a la db
	public Boolean dbConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
           	conn = DriverManager.getConnection(url, user, pw);
           	stmt = conn.createStatement();
           	return true;
		}catch(Exception E){
			E.printStackTrace();
			return false;
        }
	}
	
	//ferme la connexion a la db
	public void dbClose(){
		try{
	        stmt.close();
	        conn.close();	
		}catch(Exception E){
			E.printStackTrace();
		}
	}
	
	// execute une requete avec un SELECT passé en parametre
	public ResultSet reqSelect(String req){
		try {
			return stmt.executeQuery(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//execute une requete avec un INSERT ou UPDATE ou CREATE passé en parametre
	public void reqInsUpd(String req){
		try {
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//ajoute un user passé en parametre a la db user
	public void reqInsUser(User usr){
		reqInsUpd("INSERT INTO users(name, pw, email, inscription_date) VALUES ("
				+usr.getName()+", "
				+usr.getPassword()+", "
				+usr.getEmail()+", "
				+usr.getInscriptionDate()+")");
	}
	
	//ajoute un projet passé en parametre a la db user
	public void reqInsProj(Project proj){
		//serialisation des listes

		//requete
		reqInsUpd("INSERT INTO projects(author_id, name, presentation, goal, contributors, compensations, "
					+ "commentaries, creation_date, last_update) VALUES ("
						/*+proj.getAuthor_id()+", "
						+proj.getName()+", "
						+proj.getGoal()+", "
						+proj.toStringContributors()+", "
						+""+",*/ );
						
	}

}
