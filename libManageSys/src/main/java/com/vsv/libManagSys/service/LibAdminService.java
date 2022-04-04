package com.vsv.libManagSys.service;

import java.util.List;

import com.vsv.libManagSys.model.Books;
import com.vsv.libManagSys.model.LibAdmins;
import com.vsv.libManagSys.model.Students;


public interface LibAdminService {

	
	
	public Students addStudent(Students students);
	public LibAdmins addLibAdmin(LibAdmins libAdmins);
	public void removeStudent(Integer id);
	public void removeLibAdmin(Integer id);
	public Books addBooks(Books books);
	public void removeBook(Integer id);
	public List<LibAdmins> getAll();
	
	
	
	
}
