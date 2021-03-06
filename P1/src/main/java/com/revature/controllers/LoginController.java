package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {
	
	ObjectMapper om = new ObjectMapper();
	private LoginService ls= new LoginService();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) {
			
			
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line!=null) {
				
				
				sb.append(line);
				line= reader.readLine();
				
				
			}
			
			String body = new String(sb);
			
			LoginDTO lDTO = om.readValue(body, LoginDTO.class);
			
			
			if(ls.login(lDTO.username,lDTO.password)) {
				res.setStatus(200);
				res.getWriter().print("success!");
				
			}
			else {
				
				res.setStatus(401);
				res.getWriter().print("login failed");
			}
			
		}
				
	}

}
