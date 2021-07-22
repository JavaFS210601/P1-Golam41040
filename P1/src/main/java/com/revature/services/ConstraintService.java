package com.revature.services;

import com.revature.daos.ConstraintDAO;

public class ConstraintService {
	
	ConstraintDAO cd= new ConstraintDAO();
	public boolean constraintUsernameEmail(String ers_username, String user_email) {
		if(cd.constraintUsernameEmail(ers_username,user_email)) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
