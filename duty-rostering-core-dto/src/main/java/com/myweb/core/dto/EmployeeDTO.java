package com.myweb.core.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class EmployeeDTO implements Serializable {
	private short empId;
	private String username;
	private String password;
	private String fullName;
	private Date createDate;
	private boolean isActive;
	private boolean isAdmin;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
