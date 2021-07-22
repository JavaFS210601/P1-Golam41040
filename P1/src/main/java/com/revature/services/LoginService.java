package com.revature.services;

import com.revature.daos.CurrentUserDAO;
import com.revature.daos.LoginDAO;


public class LoginService {
	
	CurrentUserDAO cud = new CurrentUserDAO();
	
	public boolean login(String username, String password) {
		
		
		LoginDAO ld= new LoginDAO();
		cud.removeCurrentUser();
		if(ld.check(username, password)) {
			cud.addCurrentUser(username);
			return true;
		}
		else {
			return false;
		}
		
		
	}

}
