package com.myweb.core.dto;

import java.io.Serializable;
import java.util.Date;

public class DateDTO implements Serializable {
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
	public int getDateId() {
		return dateId;
	}
	public void setDateId(int dateId) {
		this.dateId = dateId;
	}
	public Date getFullDate() {
		return fullDate;
	}
	public void setFullDate(Date fullDate) {
		this.fullDate = fullDate;
	}
	public byte getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(byte dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getDayNameOfWeek() {
		return dayNameOfWeek;
	}
	public void setDayNameOfWeek(String dayNameOfWeek) {
		this.dayNameOfWeek = dayNameOfWeek;
	}
	public byte getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(byte dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	public short getDayOfYear() {
		return dayOfYear;
	}
	public void setDayOfYear(short dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public String getHolidaySeasonName() {
		return holidaySeasonName;
	}
	public void setHolidaySeasonName(String holidaySeasonName) {
		this.holidaySeasonName = holidaySeasonName;
	}
	public byte getWeekOfYear() {
		return weekOfYear;
	}
	public void setWeekOfYear(byte weekOfYear) {
		this.weekOfYear = weekOfYear;
	}
	public byte getMonthOfYear() {
		return monthOfYear;
	}
	public void setMonthOfYear(byte monthOfYear) {
		this.monthOfYear = monthOfYear;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public byte getCalendarQuarter() {
		return calendarQuarter;
	}
	public void setCalendarQuarter(byte calendarQuarter) {
		this.calendarQuarter = calendarQuarter;
	}
	public short getCalendarYear() {
		return calendarYear;
	}
	public void setCalendarYear(short calendarYear) {
		this.calendarYear = calendarYear;
	}
	public boolean getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public boolean getIsHolidaySeason() {
		return isHolidaySeason;
	}
	public void setIsHolidaySeason(boolean isHolidaySeason) {
		this.isHolidaySeason = isHolidaySeason;
	}
	public boolean getIsBusinessDay() {
		return isBusinessDay;
	}
	public void setIsBusinessDay(boolean isBusinessDay) {
		this.isBusinessDay = isBusinessDay;
	}
	public boolean getIsWeekend() {
		return isWeekend;
	}
	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	public boolean getIsLastDayOfMonth() {
		return isLastDayOfMonth;
	}
	public void setIsLastDayOfMonth(boolean isLastDayOfMonth) {
		this.isLastDayOfMonth = isLastDayOfMonth;
	}
	

	
	
}
