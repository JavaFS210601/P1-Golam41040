package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.models.Reimburstment;
import com.revature.services.ReimburstmentService;

public class ReimburstmentController {
	
	private ReimburstmentService rs = new ReimburstmentService();
	
	private ObjectMapper om = new ObjectMapper();

	public void getAllReimburstments(HttpServletResponse res) throws IOException {
		
		
		List<Reimburstment> reimburstmentlist= rs.getAllReimburstments();
		
		String json = om.writeValueAsString(reimburstmentlist);
		
		res.getWriter().print(json);
		
		res.setStatus(200);
	}

	public void userReimburstments(HttpServletResponse res) throws IOException {
		List<Reimburstment> reimburstmentlist= rs.userReimburstments();
		
		String json = om.writeValueAsString(reimburstmentlist);
		
		res.getWriter().print(json);
		
		res.setStatus(200);
		
	}

	public void addReimburstment(HttpServletRequest req, HttpServletResponse res)throws IOException {
		if(req.getMethod().equals("POST")) {
			
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line!=null) {
				
				
				sb.append(line);
				line= reader.readLine();
				
				
			}
			
			String body = new String(sb);
			Reimburstment reim = om.readValue(body, Reimburstment.class);
			if(rs.addReimburstment(reim)) {
				res.getWriter().print("success!");
				res.setStatus(200);
			}
			
			else {
				res.getWriter().print("failed");
			}
		}
		
	}

	public void updateReimburstment(HttpServletRequest req, HttpServletResponse res) throws IOException{
		if(req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line!=null) {
				
				
				sb.append(line);
				line= reader.readLine();
				
				
			}
			
			String body = new String(sb);
			Reimburstment reim = om.readValue(body, Reimburstment.class);
			if(rs.updateReimburstment(reim)) {
				res.getWriter().print("success!");
				res.setStatus(200);
			}
			else {
				res.getWriter().print("failed");
			}

		}
		
	}

}
