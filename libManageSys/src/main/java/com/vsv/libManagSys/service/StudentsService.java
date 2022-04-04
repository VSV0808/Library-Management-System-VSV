package com.vsv.libManagSys.service;

import java.util.List;

import com.vsv.libManagSys.model.Students;

public interface StudentsService {
	
	public List<Students> getAllStudents();
	public Students saveStudent(Students student);

	
	
	

}
