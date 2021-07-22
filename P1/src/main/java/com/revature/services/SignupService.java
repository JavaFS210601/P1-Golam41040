package com.revature.services;

import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;

public class SignupService {

	public boolean signup(Employee emp) {
		
		EmployeeDAO ed = new EmployeeDAO();
		if(ed.add(emp)) {
			return true;
			}
		else 
			return false;
		
		
	}

}
