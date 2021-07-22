package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.SignupService;

public class SignupController {
	
	ObjectMapper om = new ObjectMapper();
	SignupService ss= new SignupService();

	public void signup(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
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
			if(ss.signup(emp)) {
				res.setStatus(200);
			}
			
			
		}
		
	}

}
