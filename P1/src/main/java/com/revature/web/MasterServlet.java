package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ConstraintController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimburstmentController;
import com.revature.controllers.SignupController;
import com.revature.controllers.UserController;

public class MasterServlet extends HttpServlet {
	
	private ReimburstmentController rc= new ReimburstmentController();
	private LoginController lc= new LoginController();
	private UserController uc= new UserController();
	private SignupController sc= new SignupController();
	private ConstraintController cc = new ConstraintController();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/P1/","");
		
		switch(URI) {
			
		case "allreimburstments":	
			rc.getAllReimburstments(res);
			break;
			
		case "userreimburstments":
			rc.userReimburstments(res);
			break;
			
		case "addreimburstment":
			rc.addReimburstment(req,res);
			break;
		case "updatereimburstment":
			rc.updateReimburstment(req,res);
			break;
		case "login":
			lc.login(req,res);
			break;
			
		case "getusername":
			
			uc.getUsername(res);
			break;
		
		case "getusertype":
			
			uc.getUserType(res);
			break;	
				
		case "signup":
			sc.signup(req,res);
			break;
		
		case "UsernameEmailConstraint":
			cc.constraintUsernameEmail(req,res);
			break;
		
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
