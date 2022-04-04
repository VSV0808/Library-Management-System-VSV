package com.vsv.libManagSys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {
	
	@Id
	private int bookId;
	private String bookName;
	private int qty;
	
	
	
	
	





	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public Books(int bookId, String bookName,int qty) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.qty = qty;
	}




	



	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", qty=" + qty + "]";
	}



	public Books() {
		super();
	}
	
	
	
	

}
