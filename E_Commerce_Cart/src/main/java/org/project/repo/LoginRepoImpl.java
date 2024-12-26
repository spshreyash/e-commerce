package org.project.repo;

import java.sql.*;
import org.project.models.LoginModel;











public class LoginRepoImpl extends DBState implements LoginRepo {

	@Override
	public boolean isUser(LoginModel login) {
	    String query = "SELECT * FROM users WHERE uemail = ? AND password = ?";

	    try {
	        // Create a PreparedStatement for the query
	        stmt = conn.prepareStatement(query);

	        // Set the query parameters
	        stmt.setString(1, login.getUemail());
	        stmt.setString(2, login.getPassword());

	        // Execute the query
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            // Populate the login model with additional details
	            login.setUid(rs.getInt("uid"));
	            login.setUname(rs.getString("uname"));
	            login.setUsertype(rs.getString("usertype"));

	            return true; // User exists
	        }

	    } catch (SQLException ex) {
	        System.out.println("Error in isUser: " + ex.getMessage());
	    }
	    return false; // User does not exist or an error occurred
	}


	
	@Override
	public boolean registerUser(LoginModel login) {
	    String query = "INSERT INTO users (uname, uemail, password, usertype) VALUES (?, ?, ?, ?)";

	    try {
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, login.getUname());  // Set the user's name
	        stmt.setString(2, login.getUemail()); // Set the user's email
	        stmt.setString(3, login.getPassword()); // Set the user's password
	        stmt.setString(4, login.getUsertype()); // Set the user's type (e.g., admin, user)

	        int result = stmt.executeUpdate(); // Insert the user into the database
	        return result > 0; // Return true if at least one row was inserted (successful registration)
	    } catch (SQLException ex) {
	        System.out.println("Error in registerUser: " + ex.getMessage());
	        return false; // Registration failed due to an error
	    }
	}

}








//	@Override
//	public boolean registerUser(LoginModel login) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	

