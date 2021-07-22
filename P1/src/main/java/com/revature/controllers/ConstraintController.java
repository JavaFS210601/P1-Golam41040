package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.ConstraintService;

public class ConstraintController {
	
	ObjectMapper om = new ObjectMapper();
	ConstraintService cs= new ConstraintService();

	public void constraintUsernameEmail(HttpServletRequest req, HttpServletResponse res)throws IOException {
		
		if(req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line!=null) {
				
				
				sb.append(line);
				line= reader.readLine();
				
				
			}
			
			String body = new String(sb);
			Employee emp = om.readValue(body, Employee.class);
			if(cs.constraintUsernameEmail(emp.getErs_username(),emp.getUser_email())) {
			
			res.setStatus(200);
			}
			else {
				res.setStatus(404);
			}
		}
	}

	

}
