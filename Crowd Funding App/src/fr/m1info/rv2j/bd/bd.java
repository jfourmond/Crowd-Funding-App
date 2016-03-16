package fr.m1info.rv2j.bd;

import java.sql.*;

public class bd {
	//variables
	private Connection conn = null;
    private Statement stmt = null;
	private String url = "jdbc:mysql://localhost/fr_m1info_rv2j";
	private String user;
	private String pw;
		   
	//constructeur
	bd(String usr, String p){
		user=usr;
		pw=p;
	}
	
	//methodes
	public Boolean dbConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
           	conn = DriverManager.getConnection("jdbc:mysql:" + url, user, pw);
           	stmt = conn.createStatement();
           	return true;
		}catch(Exception E){
			E.printStackTrace();
			return false;
        }
	}
	
	public void dbClose(){
		try{
	        stmt.close();
	        conn.close();	
		}catch(Exception E){
			E.printStackTrace();
		}
	}
	
	public ResultSet reqSelect(String req){
		try {
			return stmt.executeQuery(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void reqInsUpd(String req){
		try {
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) {
		test T = new test("root", "root");
		T.dbConnect();
		T.reqInsUpd("INSERT INTO users (name, pw, email, inscription_date) VALUES (testname, testpw, testmail@mail.fr, 03/16/2016)");
		ResultSet rs = T.reqSelect("SELECT * FROM users");
		T.dbClose();
		
        if (rs != null) {
	        try{
	            while (rs.next()) 
	                System.out.println("Valeur: " + rs.getString(1));
        	}catch(Exception E){
        		E.printStackTrace();
        	}
        }
	}*/

}
