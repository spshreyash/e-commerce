package org.project.repo;
import java.io.*;
import java.sql.*;
import java.util.*;

public class DbConfig {

	protected  static Connection conn;
	protected  static PreparedStatement stmt;
	protected  static ResultSet rs;
	private static DbConfig db=null;
	// atomatic call parent constrctor 
//	private DbConfig() 
	protected DbConfig() 
	{
		
		try
 		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 File  f=new File("");
			 String path=f.getAbsolutePath();
			 FileInputStream inputStream = new FileInputStream(path+"\\src\\main\\resources\\application.properties");
           
			  Properties p  = new Properties();
			  p.load(inputStream);
//			 System.out.println(path);

			  
			  
			  String driverClasName=p.getProperty("Driver");
			  String username=p.getProperty("username");
			  String pass=p.getProperty("pass");
			  String url=p.getProperty("url");
			  
//			 System.out.println(driverClasName);
//			 System.out.println(username);
//			 System.out.println(pass);
//			 System.out.println(url);
			  
			  
			  DbConfig.conn = DriverManager.getConnection(url, username, pass);  // Correct assignment to the static field

			  
//			  Connection conn=DriverManager.getConnection(url,username,pass);


			  
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
		}
	}
	public static DbConfig getInstance()
	{
		if(db==null)
		{
			db=new DbConfig();
		}
		return db;
	}
	public static  Connection getConn()
	{
		return conn;
	}
	public static PreparedStatement getStatemen()
	{
		return stmt;
	}
	public  static ResultSet  getResult()
	{
		return  rs;
	}
	
}
