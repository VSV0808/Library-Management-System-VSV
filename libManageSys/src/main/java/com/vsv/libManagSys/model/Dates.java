package com.vsv.libManagSys.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;


@Entity
public class Dates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slotNo;
	private int rollNo;
	private int book_id;
	private Date dateBorrowed;
	private Date dueDate;
	
	
	
	
	public int getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public Date getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Dates(int slotNo,int rollNo, int book_id, Date dateBorrowed, Date dueDate) {
		super();
		this.slotNo=slotNo;
		this.rollNo = rollNo;
		this.book_id = book_id;
		this.dateBorrowed = dateBorrowed;
		this.dueDate = dueDate;
		
	}
	public Dates() {
		super();
		
	}
	@Override
	public String toString() {
		return "Dates [slotNo=" + slotNo + ", rollNo=" + rollNo + ", book_id=" + book_id + ", dateBorrowed="
				+ dateBorrowed + ", dueDate=" + dueDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
