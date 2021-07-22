package com.revature.daos;

import java.util.List;

import com.revature.models.Reimburstment;

public interface ReimburstmentInterface {
	
	public List<Reimburstment> getAllReimburstment();
	public void update(int Id,String name,String data_type);
	public List<Reimburstment> userReimburstments();
	public boolean addReimburstment(Reimburstment reim);
	public boolean updateReimburstment(Reimburstment reim);
}
