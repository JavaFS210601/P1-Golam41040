package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.utils.ConnectionUtil;

public class LoginDAO implements LoginInterface {

	@Override
	public boolean check (String username, String password) {
			
		try (Connection conn = ConnectionUtil.getConnection()){
			String pass= null;
			String sql1 = "Select ers_password from \"ERS\".ERS_USERS where ers_username= ? ;";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, username);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				pass= rs1.getString("ers_password");
			}
			if(pass ==null) {
				return false;
			}
			if(pass.equals(password)) {
				
				
				return true;
			}
			else {
				return false;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

}
