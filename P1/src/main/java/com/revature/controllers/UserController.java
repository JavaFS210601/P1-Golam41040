package com.revature.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

public class UserController {

	

		ObjectMapper om = new ObjectMapper();
		private UserService us= new UserService();
		 
		 public void getUsername(HttpServletResponse res) throws IOException {
			 
			 String username= us.getUsername();
			 
			 String json = om.writeValueAsString(username);
				
				res.getWriter().print(json);
				
				res.setStatus(200);
		 
		 }

		public void getUserType(HttpServletResponse res) throws IOException{
			
			String userType= us.getUserType();
			 
			 String json = om.writeValueAsString(userType);
				
				res.getWriter().print(json);
				
				res.setStatus(200);
			
		}
		
		
		
	}


