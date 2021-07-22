package com.revature.models;

public class Reimburstment {
	private int reimb_id;
	private int reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_description;
	private String reimb_receipt;
	private String reimb_author_name;
	private String reimb_solver_name;
	private String reimb_status;
	private String reimb_type;
	public Reimburstment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Reimburstment(int reimb_id, String reimb_status) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_status = reimb_status;
	}



	public Reimburstment(int reimb_amount, String reimb_description, String reimb_receipt, String reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_type = reimb_type;
	}

	public Reimburstment(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, String reimb_receipt, String reimb_author_name, String reimb_solver_name,
			String reimb_status, String reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author_name = reimb_author_name;
		this.reimb_solver_name = reimb_solver_name;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}
	public Reimburstment(int reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description,
			String reimb_receipt, String reimb_author_name, String reimb_solver_name, String reimb_status,
			String reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author_name = reimb_author_name;
		this.reimb_solver_name = reimb_solver_name;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}
	@Override
	public String toString() {
		return "Reimburstment [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author_name=" + reimb_author_name
				+ ", reimb_solver_name=" + reimb_solver_name + ", reimb_status=" + reimb_status + ", reimb_type="
				+ reimb_type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimb_amount;
		result = prime * result + ((reimb_author_name == null) ? 0 : reimb_author_name.hashCode());
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((reimb_receipt == null) ? 0 : reimb_receipt.hashCode());
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + ((reimb_solver_name == null) ? 0 : reimb_solver_name.hashCode());
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimburstment other = (Reimburstment) obj;
		if (reimb_amount != other.reimb_amount)
			return false;
		if (reimb_author_name == null) {
			if (other.reimb_author_name != null)
				return false;
		} else if (!reimb_author_name.equals(other.reimb_author_name))
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (reimb_receipt == null) {
			if (other.reimb_receipt != null)
				return false;
		} else if (!reimb_receipt.equals(other.reimb_receipt))
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_solver_name == null) {
			if (other.reimb_solver_name != null)
				return false;
		} else if (!reimb_solver_name.equals(other.reimb_solver_name))
			return false;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		return true;
	}
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public int getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public String getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public String getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public String getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(String reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	public String getReimb_author_name() {
		return reimb_author_name;
	}
	public void setReimb_author_name(String reimb_author_name) {
		this.reimb_author_name = reimb_author_name;
	}
	public String getReimb_solver_name() {
		return reimb_solver_name;
	}
	public void setReimb_solver_name(String reimb_solver_name) {
		this.reimb_solver_name = reimb_solver_name;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	
	
	
}
