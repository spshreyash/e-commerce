package org.project.repo;

import org.project.models.LoginModel;

public interface LoginRepo {

	 boolean isUser(LoginModel login);
//	 boolean registerUser(LoginModel login);
	  boolean registerUser(LoginModel login);
}
