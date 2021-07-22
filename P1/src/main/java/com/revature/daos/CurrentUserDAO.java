package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.revature.utils.ConnectionUtil;

public class CurrentUserDAO {
	public String getCurrentUser() {
	try (Connection conn = ConnectionUtil.getConnection()){
		String currentUser= null;
		ResultSet rs =null;
		String sql = "Select username from \"ERS\".USER_CURRENT";
		Statement s = conn.createStatement();
		rs = s.executeQuery(sql);
		while(rs.next()) {
			currentUser= rs.getString("username");
		}
		
		return currentUser;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public void removeCurrentUser() {
		try (Connection conn = ConnectionUtil.getConnection()){
			String result = getCurrentUser();
			if(result!=null) {
				String sql = "delete from \"ERS\".USER_CURRENT";
				Statement s = conn.createStatement();
				s.executeUpdate(sql);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void addCurrentUser(String username) {
			try (Connection conn = ConnectionUtil.getConnection()){
				String sql = "INSERT INTO \"ERS\".USER_CURRENT (username)"
						+ " VALUES(?);";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,username);
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	public String getCurrentUserType() {
		try (Connection conn = ConnectionUtil.getConnection()){
		String username = getCurrentUser();
		String currentUserTypeId= null;
		ResultSet rs =null;
		String sql = "SELECT user_role_id from \"ERS\".ERS_USERS where ers_username= ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,username);
		rs= ps.executeQuery();
		while(rs.next()) {
			currentUserTypeId= rs.getString("user_role_id");
			
		}
		
		return currentUserTypeId;
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getCurrentUserId() {
		try (Connection conn = ConnectionUtil.getConnection()){
		String username = getCurrentUser();
		int currentUserId= 0;
		ResultSet rs =null;
		String sql = "SELECT ers_user_id from \"ERS\".ERS_USERS where ers_username= ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,username);
		rs= ps.executeQuery();
		while(rs.next()) {
			currentUserId= rs.getInt("ers_user_id");
			
		}
		
		return currentUserId;
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getCurrentUserName() {
		try (Connection conn = ConnectionUtil.getConnection()){
			String username = getCurrentUser();
			String currentUsername= null;
			ResultSet rs =null;
			String sql = "Select user_first_name,user_last_name from \"ERS\".ERS_USERS  where ers_username= ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			while(rs.next()) {
				currentUsername= rs.getString("user_first_name");
				currentUsername+= " ";
				currentUsername= rs.getString("user_last_name");
				
			}
			
			return currentUsername;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	
	
}
