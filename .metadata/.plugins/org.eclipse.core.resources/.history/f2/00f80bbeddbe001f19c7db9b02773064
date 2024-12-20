

package org.project.services;

import org.project.models.LoginModel;
import org.project.repo.LoginRepo;
import org.project.repo.LoginRepoImpl;

public class LoginServiceImp implements LoginService {

    // Create an instance of LoginRepo to interact with the db 
    LoginRepo loginRepo = new LoginRepoImpl();
    
    

    @Override
    public boolean isUser(LoginModel login) {
        // Call the LoginRepo's isUser method to check credentials in the database
        return loginRepo.isUser(login);
    }

	@Override
	  public boolean registerUser(LoginModel login) {
        // Call the LoginRepo's registerUser method to insert a new user into the database
        return loginRepo.registerUser(login);
    }
}

