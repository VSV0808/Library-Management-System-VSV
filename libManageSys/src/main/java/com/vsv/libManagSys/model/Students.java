package com.vsv.libManagSys.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Students {
	
	@Id
	private int rollNo;
	
	private String studentName;
	
	
	
	@ManyToMany
	@JoinTable(name = "books_students",joinColumns = @JoinColumn(name="rollNo",referencedColumnName = "rollNo"),inverseJoinColumns = @JoinColumn(name="bookId",referencedColumnName = "bookId"))
	private List<Books> booksOfStudents;

	
	public Students(int rollNo, String studentName,List<Books> booksOfStudents) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.booksOfStudents=booksOfStudents;
	}

	
	


	public List<Books> getBooksOfStudents() {
		return booksOfStudents;
	}





	public void setBooksOfStudents(List<Books> booksOfStudents) {
		this.booksOfStudents = booksOfStudents;
	}





	public int getRollNo() {
		return rollNo;
	}





	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}





	public String getStudentName() {
		return studentName;
	}





	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}





	@Override
	public String toString() {
		return "Students [rollNo=" + rollNo + ", studentName=" + studentName + "]";
	}





	public Students() {
		super();
	}
	
	
	

}
