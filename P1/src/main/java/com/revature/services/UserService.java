package com.revature.services;

import com.revature.daos.CurrentUserDAO;

public class UserService {
	
	CurrentUserDAO cud= new CurrentUserDAO();
	
	public String getUsername() {
		
		String username = cud.getCurrentUser();
		
		 
		return username;
	}

	public String getUserType() {
		String userType = cud.getCurrentUserType();
		System.out.println(userType);
		 
		return userType;
	}

}
