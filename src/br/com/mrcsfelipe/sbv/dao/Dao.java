package br.com.mrcsfelipe.sbv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	
	PreparedStatement stmt;
	Connection con;
	ResultSet rs;
	
	
	protected void open() throws Exception{
		
		String url = "jdbc:postgresql://localhost:5432/lp2a2";
		//String user = "lp2";
		//String pass = "eddy";
		String user = "postgres" , password = "marcos";
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url,user,password);
	}
	
	
	protected void close() throws Exception{
		con.close();
	}

}
