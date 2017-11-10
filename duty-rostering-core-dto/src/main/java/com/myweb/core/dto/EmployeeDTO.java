package com.myweb.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

public class EmployeeDTO implements Serializable {
	private short empId;
	private String username;
	private String password;
	private String fullName;
	private Timestamp createDate;
	private boolean isAdmin;
	private boolean isActive;

	public short getEmpId() {
		return empId;
	}

	public void setEmpId(short empId) {
		this.empId = empId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createdDate) {
		this.createDate = createdDate;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
