package com.revature;

import static org.junit.Assert.assertFalse;

import org.junit.Test;


import com.revature.models.Employee;
import com.revature.models.Reimburstment;
import com.revature.services.ConstraintService;
import com.revature.services.LoginService;
import com.revature.services.ReimburstmentService;
import com.revature.services.SignupService;

public class Tests {
	LoginService ls = new LoginService();
	ReimburstmentService rs = new ReimburstmentService();
	SignupService ss= new SignupService();
	ConstraintService cs = new ConstraintService();
	
	@Test
	public void testNullCredentials(){
		
		System.out.println("Null Credentials Testing");
		
		assertFalse(ls.login("", ""));
		
		//user can't login with blank credentials.
	}
	@Test
	public void testNullPassword(){
		
		System.out.println("Null Password Testing");
		
		assertFalse(ls.login("golam56", ""));
		
		//although golam56 username exist in the system, user can't login with blank a password.
	}
	
	@Test
	public void testReimburstmentStatus(){
		
		System.out.println("Reimburstment Status Testing");
		Reimburstment reimb = new Reimburstment(1,"1");
		assertFalse(rs.updateReimburstment(reimb));
		//we can't update a reimburstment's status to submitted(value for that in the DB is 1)		
		
	}
	
	@Test
	public void testReimburstmentAmount(){
		
		System.out.println("Reimburstment Amount Testing");
		Reimburstment reimb = new Reimburstment(0,"test description","test receipt","1");
		assertFalse(rs.addReimburstment(reimb));
		//we can't add a reimburstment with an amount of 0 $		
		
	}
	
	
	@Test
	public void testNullUsername() {
		System.out.println("Null Signup Information Testing");
		Employee emp = new Employee("","password","firstname","lastname","email",1);
		assertFalse(ss.signup(emp));
		//user can't sign up with null username;
		
	}
	
	
	@Test
	public void testNullPassowrd() {
		System.out.println("Null Signup Information Testing");
		Employee emp = new Employee("username","","firstname","lastname","email",1);
		assertFalse(ss.signup(emp));
		//user can't sign up with null password;
		
	}
	
	@Test
	public void testNullEmail() {
		System.out.println("Null Signup Information Testing");
		Employee emp = new Employee("username","password","firstname","lastname","",1);
		assertFalse(ss.signup(emp));
		//user can't sign up with null email;
		
	}
	
	@Test
	public void testRoleIDSignupValue() {
		System.out.println("Role ID Signup Information Testing");
		Employee emp = new Employee("Username","password","Firstname","LastName","Email",3);
		assertFalse(ss.signup(emp));
		//user can't sign up with a Role Id value other than 1 or 2;
		
	}
	
	@Test
	public void testUniqueUsername() {
		System.out.println("Unique Username Testing");
		
		
		assertFalse(cs.constraintUsernameEmail("golam56","sample@email.com"));
		
		//username golam56 already exists. A new user can not sign up with this username .
		
	}
	
	
	@Test
	public void testUniqueEmail() {
		System.out.println("Unique Email Testing");
		
		
		assertFalse(cs.constraintUsernameEmail("sampleusername","golam.zilani@revature.net"));
		
		//email golam.zilani@revature.net already exists. A new user can not sign up with this email. 
		
	}
	
	
	
	
	
}
