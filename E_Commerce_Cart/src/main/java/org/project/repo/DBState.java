package org.project.repo;

import java.sql.*;

import org.project.models.LoginModel;
public class DBState {

	DbConfig config=DbConfig.getInstance();
	
      protected Connection conn=config.getConn();
      protected PreparedStatement  stmt=config.getStatemen();
      protected ResultSet rs=config.getResult() ;
//	public boolean isUser(LoginModel login) {
		// TODO Auto-generated method stub
//	public boolean registerUser(LoginModel login) {
//		// TODO Auto-generated method stub
//		return false;
	}
		
	



