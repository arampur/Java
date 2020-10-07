package com.bookManagementAPI.program;

import java.util.Date;

public class BookReservation {
	private String bookId;
	private Date startDate;
	private Date endDate;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public BookReservation(String bookId, Date startDate, Date endDate) {
		super();
		this.bookId = bookId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public BookReservation() {
		
	}
	
}
