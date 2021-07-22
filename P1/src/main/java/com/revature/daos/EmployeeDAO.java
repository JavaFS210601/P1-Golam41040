package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAO implements EmployeeInterface {

	@Override
	public boolean add(Employee employee) {
		if(employee.getErs_username()==null||employee.getErs_password()==null||employee.getUser_first_name()==null||employee.getUser_last_name()==null||
				employee.getUser_email()==null||employee.getRole_id()<1||employee.getRole_id()>2) {
			return false;
		}
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO \"ERS\".ERS_USERS (ers_username, ers_password, user_first_name, user_last_name, \r\n"
					+ "						user_email, user_role_id)"
					+ "VALUES(?,?,?,?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,employee.getErs_username());
			ps.setString(2, employee.getErs_password());
			ps.setString(3, employee.getUser_first_name());
			ps.setString(4, employee.getUser_last_name());
			ps.setString(5, employee.getUser_email());
			ps.setInt(6, employee.getRole_id());
			ps.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
