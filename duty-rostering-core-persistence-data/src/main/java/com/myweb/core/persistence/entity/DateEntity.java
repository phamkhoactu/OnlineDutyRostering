package com.myweb.core.persistence.entity;

import java.util.Date;

// default package
// Generated 25-Oct-2017 23:46:53 by Hibernate Tools 5.2.5.Final

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DateEntity generated by hbm2java
 */
@Entity
@Table(name = "date", catalog = "dutyrostering")
public class DateEntity{

	private int dateId;
	private Date fullDate;
	private byte dayOfWeek;
	private String dayNameOfWeek;
	private byte dayOfMonth;
	private short dayOfYear;
	private boolean isHoliday;
	private boolean isHolidaySeason;
	private String holidayName;
	private String holidaySeasonName;
	private boolean isBusinessDay;
	private boolean isWeekend;
	private byte weekOfYear;
	private byte monthOfYear;
	private String monthName;
	private boolean isLastDayOfMonth;
	private byte calendarQuarter;
	private short calendarYear;
	private List<RosterEntity> rosterEntities;

	public DateEntity() {
	}

	public DateEntity(int dateId, byte dayOfWeek, String dayNameOfWeek, byte dayOfMonth, short dayOfYear, boolean isHoliday,
			boolean isHolidaySeason, boolean isBusinessDay, boolean isWeekend, byte weekOfYear, byte monthOfYear,
			String monthName, boolean isLastDayOfMonth, byte calendarQuarter, short calendarYear) {
		this.dateId = dateId;
		this.dayOfWeek = dayOfWeek;
		this.dayNameOfWeek = dayNameOfWeek;
		this.dayOfMonth = dayOfMonth;
		this.dayOfYear = dayOfYear;
		this.isHoliday = isHoliday;
		this.isHolidaySeason = isHolidaySeason;
		this.isBusinessDay = isBusinessDay;
		this.isWeekend = isWeekend;
		this.weekOfYear = weekOfYear;
		this.monthOfYear = monthOfYear;
		this.monthName = monthName;
		this.isLastDayOfMonth = isLastDayOfMonth;
		this.calendarQuarter = calendarQuarter;
		this.calendarYear = calendarYear;
	}

	public DateEntity(int dateId, Date fullDate, byte dayOfWeek, String dayNameOfWeek, byte dayOfMonth, short dayOfYear,
			boolean isHoliday, boolean isHolidaySeason, String holidayName, String holidaySeasonName,
			boolean isBusinessDay, boolean isWeekend, byte weekOfYear, byte monthOfYear, String monthName,
			boolean isLastDayOfMonth, byte calendarQuarter, short calendarYear, List<RosterEntity> rosterEntities) {
		this.dateId = dateId;
		this.fullDate = fullDate;
		this.dayOfWeek = dayOfWeek;
		this.dayNameOfWeek = dayNameOfWeek;
		this.dayOfMonth = dayOfMonth;
		this.dayOfYear = dayOfYear;
		this.isHoliday = isHoliday;
		this.isHolidaySeason = isHolidaySeason;
		this.holidayName = holidayName;
		this.holidaySeasonName = holidaySeasonName;
		this.isBusinessDay = isBusinessDay;
		this.isWeekend = isWeekend;
		this.weekOfYear = weekOfYear;
		this.monthOfYear = monthOfYear;
		this.monthName = monthName;
		this.isLastDayOfMonth = isLastDayOfMonth;
		this.calendarQuarter = calendarQuarter;
		this.calendarYear = calendarYear;
		this.rosterEntities = rosterEntities;
	}

	@Id

	@Column(name = "DATE_ID", unique = true, nullable = false)
	public int getDateId() {
		return this.dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FULL_DATE", length = 10)
	public Date getFullDate() {
		return this.fullDate;
	}

	public void setFullDate(Date fullDate) {
		this.fullDate = fullDate;
	}

	@Column(name = "DAY_OF_WEEK", nullable = false)
	public byte getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(byte dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Column(name = "DAY_NAME_OF_WEEK", nullable = false, length = 10)
	public String getDayNameOfWeek() {
		return this.dayNameOfWeek;
	}

	public void setDayNameOfWeek(String dayNameOfWeek) {
		this.dayNameOfWeek = dayNameOfWeek;
	}

	@Column(name = "DAY_OF_MONTH", nullable = false)
	public byte getDayOfMonth() {
		return this.dayOfMonth;
	}

	public void setDayOfMonth(byte dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	@Column(name = "DAY_OF_YEAR", nullable = false)
	public short getDayOfYear() {
		return this.dayOfYear;
	}

	public void setDayOfYear(short dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	@Column(name = "IS_HOLIDAY", nullable = false)
	public boolean isIsHoliday() {
		return this.isHoliday;
	}

	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	@Column(name = "IS_HOLIDAY_SEASON", nullable = false)
	public boolean isIsHolidaySeason() {
		return this.isHolidaySeason;
	}

	public void setIsHolidaySeason(boolean isHolidaySeason) {
		this.isHolidaySeason = isHolidaySeason;
	}

	@Column(name = "HOLIDAY_NAME", length = 50)
	public String getHolidayName() {
		return this.holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	@Column(name = "HOLIDAY_SEASON_NAME", length = 50)
	public String getHolidaySeasonName() {
		return this.holidaySeasonName;
	}

	public void setHolidaySeasonName(String holidaySeasonName) {
		this.holidaySeasonName = holidaySeasonName;
	}

	@Column(name = "IS_BUSINESS_DAY", nullable = false)
	public boolean isIsBusinessDay() {
		return this.isBusinessDay;
	}

	public void setIsBusinessDay(boolean isBusinessDay) {
		this.isBusinessDay = isBusinessDay;
	}

	@Column(name = "IS_WEEKEND", nullable = false)
	public boolean isIsWeekend() {
		return this.isWeekend;
	}

	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	@Column(name = "WEEK_OF_YEAR", nullable = false)
	public byte getWeekOfYear() {
		return this.weekOfYear;
	}

	public void setWeekOfYear(byte weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	@Column(name = "MONTH_OF_YEAR", nullable = false)
	public byte getMonthOfYear() {
		return this.monthOfYear;
	}

	public void setMonthOfYear(byte monthOfYear) {
		this.monthOfYear = monthOfYear;
	}

	@Column(name = "MONTH_NAME", nullable = false, length = 10)
	public String getMonthName() {
		return this.monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	@Column(name = "IS_LAST_DAY_OF_MONTH", nullable = false)
	public boolean isIsLastDayOfMonth() {
		return this.isLastDayOfMonth;
	}

	public void setIsLastDayOfMonth(boolean isLastDayOfMonth) {
		this.isLastDayOfMonth = isLastDayOfMonth;
	}

	@Column(name = "CALENDAR_QUARTER", nullable = false)
	public byte getCalendarQuarter() {
		return this.calendarQuarter;
	}

	public void setCalendarQuarter(byte calendarQuarter) {
		this.calendarQuarter = calendarQuarter;
	}

	@Column(name = "CALENDAR_YEAR", nullable = false)
	public short getCalendarYear() {
		return this.calendarYear;
	}

	public void setCalendarYear(short calendarYear) {
		this.calendarYear = calendarYear;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dateEntity")
	public List<RosterEntity> getRosterEntities() {
		return this.rosterEntities;
	}

	public void setRosterEntities(List<RosterEntity> rosterEntities) {
		this.rosterEntities = rosterEntities;
	}

}