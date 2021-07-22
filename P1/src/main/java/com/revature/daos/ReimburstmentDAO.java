package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Reimburstment;
import com.revature.utils.ConnectionUtil;

public class ReimburstmentDAO implements ReimburstmentInterface {

	CurrentUserDAO cud = new CurrentUserDAO();
	

	@Override
	public List<Reimburstment> getAllReimburstment() {
		try (Connection conn = ConnectionUtil.getConnection()){
		ResultSet rs =null;
		String sql = "Select * from \"ERS\".ERS_REIMBURSTMENT ORDER BY reimb_id ;";
		Statement s = conn.createStatement();
		rs = s.executeQuery(sql);
		List <Reimburstment> reimburstmentlist = new ArrayList<>();
		
		while(rs.next()) {
			
			
			int id=rs.getInt("reimb_id");
			int amount =rs.getInt("reimb_amount");
			String sub_date= rs.getString("reimb_submitted");
			String res_date= rs.getString("reimb_resolved");
			String desc= rs.getString("reimb_description");
			String reciept= rs.getString("reimb_receipt");
			int author_id= rs.getInt("reimb_author");
			int resolver_id =rs.getInt("reimb_resolver");
			int status_id = rs.getInt("reimb_status_id");
			int type_id= rs.getInt("reimb_type_id");
			
			
			String author_name = null;
			String resolver_name = null;
			String status = null;
			String type = null;
			
			String sql1 = "Select user_first_name,user_last_name from \"ERS\".ERS_USERS where ers_user_id=?;";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, author_id);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				String author_f_name= rs1.getString("user_first_name");
				String author_l_name = rs1.getString("user_last_name");
				 author_name= author_f_name+" "+author_l_name;
			}
			
			
			ResultSet rs2=null;
			
			String sql2 = "Select user_first_name,user_last_name from \"ERS\".ERS_USERS where ers_user_id=? ;";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, resolver_id);
			rs2=ps2.executeQuery();
			while (rs2.next()) {
				String resolver_f_name= rs2.getString("user_first_name");
				String resolver_l_name = rs2.getString("user_last_name");
				 resolver_name= resolver_f_name+" "+resolver_l_name;
			}
			
			String sql3 = "Select reimb_status from \"ERS\".ERS_REIMBURSTMENT_STATUS where reimb_status_id=?;";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, status_id);
			ResultSet rs3=ps3.executeQuery();
			while (rs3.next()) {
				 status= rs3.getString("reimb_status");
				 
			}
			
			String sql4 = "Select reimb_type from \"ERS\".ERS_REIMBURSTMENT_TYPE where reimb_type_id=?;";
			PreparedStatement ps4 = conn.prepareStatement(sql4);
			ps4.setInt(1, type_id);
			ResultSet rs4=ps4.executeQuery();
			while (rs4.next()) {
				 type= rs4.getString("reimb_type");
			}
			
			
			
			
			
			Reimburstment reimburstment= new Reimburstment(
															id,
															amount,
															sub_date,
															res_date,
															desc,
															reciept,
															author_name,
															resolver_name,
															status,
															type);
			reimburstmentlist.add(reimburstment);
			
			
		}
		return reimburstmentlist;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(int Id, String name, String data_type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimburstment> userReimburstments() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			
			int auth_id= cud.getCurrentUserId();
			
			ResultSet rs =null;
			String sql = "Select * from \"ERS\".ERS_REIMBURSTMENT where reimb_author= ? ORDER BY reimb_id;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, auth_id);

			rs = ps.executeQuery();
			List <Reimburstment> reimburstmentlist = new ArrayList<>();
			
			while(rs.next()) {
				
				
				int id=rs.getInt("reimb_id");
				int amount =rs.getInt("reimb_amount");
				String sub_date= rs.getString("reimb_submitted");
				String res_date= rs.getString("reimb_resolved");
				String desc= rs.getString("reimb_description");
				String reciept= rs.getString("reimb_receipt");
				int author_id= rs.getInt("reimb_author");
				int resolver_id =rs.getInt("reimb_resolver");
				int status_id = rs.getInt("reimb_status_id");
				int type_id= rs.getInt("reimb_type_id");
				
				
				String author_name = null;
				String resolver_name = null;
				String status = null;
				String type = null;
				
				String sql1 = "Select user_first_name,user_last_name from \"ERS\".ERS_USERS where ers_user_id=?;";
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ps1.setInt(1, author_id);
				ResultSet rs1=ps1.executeQuery();
				while (rs1.next()) {
					String author_f_name= rs1.getString("user_first_name");
					String author_l_name = rs1.getString("user_last_name");
					 author_name= author_f_name+" "+author_l_name;
				}
				
				
				ResultSet rs2=null;
				
				String sql2 = "Select user_first_name,user_last_name from \"ERS\".ERS_USERS where ers_user_id=?;";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, resolver_id);
				rs2=ps2.executeQuery();
				while (rs2.next()) {
					String resolver_f_name= rs2.getString("user_first_name");
					String resolver_l_name = rs2.getString("user_last_name");
					 resolver_name= resolver_f_name+" "+resolver_l_name;
				}
				
				String sql3 = "Select reimb_status from \"ERS\".ERS_REIMBURSTMENT_STATUS where reimb_status_id=?;";
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, status_id);
				ResultSet rs3=ps3.executeQuery();
				while (rs3.next()) {
					 status= rs3.getString("reimb_status");
					 
				}
				
				String sql4 = "Select reimb_type from \"ERS\".ERS_REIMBURSTMENT_TYPE where reimb_type_id=?;";
				PreparedStatement ps4 = conn.prepareStatement(sql4);
				ps4.setInt(1, type_id);
				ResultSet rs4=ps4.executeQuery();
				while (rs4.next()) {
					 type= rs4.getString("reimb_type");
				}
				
				
				
				
				
				Reimburstment reimburstment= new Reimburstment(
																id,
																amount,
																sub_date,
																res_date,
																desc,
																reciept,
																author_name,
																resolver_name,
																status,
																type);
				reimburstmentlist.add(reimburstment);
				
				
			}
			return reimburstmentlist;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimburstment(Reimburstment reim) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			if(reim.getReimb_amount()==0) {
				return false;
			}
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
			
			Date date = new Date(); //new date from java.util package
			
			String currentDate = dateFormat.format(date);
			int author = cud.getCurrentUserId();
			String sql= "Insert into \"ERS\".ers_reimburstment (reimb_amount,reimb_submitted,"
					+ "reimb_description,reimb_receipt,reimb_author,reimb_status_id,reimb_type_id)"
					+ "values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,reim.getReimb_amount());
			ps.setDate(2, java.sql.Date.valueOf(currentDate));
			ps.setString(3, reim.getReimb_description());
			ps.setString(4, reim.getReimb_receipt());
			ps.setInt(5, author);
			ps.setInt(6,1);
			ps.setInt(7, Integer.parseInt(reim.getReimb_type()));
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimburstment(Reimburstment reim) {
try(Connection conn = ConnectionUtil.getConnection()){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
			
			Date date = new Date(); //new date from java.util package
			
			String currentDate = dateFormat.format(date);
			int resolver = cud.getCurrentUserId();
			String sql= "UPDATE \"ERS\".ers_reimburstment "
					+ "SET reimb_status_id = ? ,reimb_resolver = ? , reimb_resolved = ? "
					+ " WHERE reimb_id = ? ;";
			
			if(reim.getReimb_status()=="1") {
				return false;
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(reim.getReimb_status()));
			ps.setInt(2, resolver);
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, reim.getReimb_id());
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
