package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class ConstraintDAO {

	public boolean constraintUsernameEmail(String ers_username, String user_email) {
		try(Connection conn= ConnectionUtil.getConnection()){
			ResultSet rs1= null;
			String sql1= "Select ers_username from \"ERS\".ers_users where ers_username=?;";
			PreparedStatement ps1= conn.prepareStatement(sql1);
			ps1.setString(1, ers_username);
			rs1= ps1.executeQuery();
			while(rs1.next()) {
				String username = rs1.getString("ers_username");
				if(username.equals(ers_username)) {
					
					return false;
				}
			}
			ResultSet rs2= null;
			String sql2= "Select user_email from \"ERS\".ers_users where user_email=?;";
			PreparedStatement ps2= conn.prepareStatement(sql2);
			ps2.setString(1, user_email);
			rs2= ps2.executeQuery();
			while(rs2.next()) {
				String email = rs2.getString("user_email");
				if(email.equals(user_email)) {
					
					return false;
				}
			}
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
