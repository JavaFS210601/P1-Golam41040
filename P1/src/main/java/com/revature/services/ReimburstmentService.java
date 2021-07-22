package com.revature.services;

import java.util.List;

import com.revature.daos.ReimburstmentDAO;
import com.revature.daos.ReimburstmentInterface;
import com.revature.models.Reimburstment;

public class ReimburstmentService {

	
	private ReimburstmentInterface rd = new ReimburstmentDAO();
	
	public List<Reimburstment> getAllReimburstments(){
		return rd.getAllReimburstment();
	}

	public List<Reimburstment> userReimburstments() {
		
		
		
		return rd.userReimburstments();
	}

	public boolean addReimburstment(Reimburstment reim) {
		if(rd.addReimburstment(reim)) {
			return true;
		}
		else
			return false;
	}

	public boolean updateReimburstment(Reimburstment reim) {
		if(rd.updateReimburstment(reim)) {
			return true;
		}
		else
			return false;
	}
	
}
