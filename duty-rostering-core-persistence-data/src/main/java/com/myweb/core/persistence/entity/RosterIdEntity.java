package com.myweb.core.persistence.entity;

import java.io.Serializable;

// default package
// Generated 25-Oct-2017 23:46:53 by Hibernate Tools 5.2.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RosterIdEntity generated by hbm2java
 */
@Embeddable
public class RosterIdEntity implements Serializable{

	private short empId;
	private int dateId;
	private byte shift;

	public RosterIdEntity() {
	}

	public RosterIdEntity(short empId, int dateId, byte shift) {
		this.empId = empId;
		this.dateId = dateId;
		this.shift = shift;
	}

	@Column(name = "EMP_ID", nullable = false)
	public short getEmpId() {
		return this.empId;
	}

	public void setEmpId(short empId) {
		this.empId = empId;
	}

	@Column(name = "DATE_ID", nullable = false)
	public int getDateId() {
		return this.dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	@Column(name = "SHIFT", nullable = false)
	public byte getShift() {
		return this.shift;
	}

	public void setShift(byte shift) {
		this.shift = shift;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RosterIdEntity))
			return false;
		RosterIdEntity castOther = (RosterIdEntity) other;

		return (this.getEmpId() == castOther.getEmpId()) && (this.getDateId() == castOther.getDateId())
				&& (this.getShift() == castOther.getShift());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmpId();
		result = 37 * result + this.getDateId();
		result = 37 * result + this.getShift();
		return result;
	}

}
