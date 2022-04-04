package com.vsv.libManagSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vsv.libManagSys.model.Books;
import com.vsv.libManagSys.model.LibAdmins;
import com.vsv.libManagSys.model.Students;
import com.vsv.libManagSys.repository.BooksRepository;
import com.vsv.libManagSys.repository.LibAdminsRepository;
import com.vsv.libManagSys.repository.StudentsRepository;

@Service
public class LibAdminServiceImpl implements LibAdminService {

	@Autowired
	private LibAdminsRepository libAdminsRepository;
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private BooksRepository booksRepository;

	@Override
	public Students addStudent(Students students) {
		
		return studentsRepository.save(students) ;
	}

	@Override
	public LibAdmins addLibAdmin(LibAdmins libAdmins) {
		
		return libAdminsRepository.save(libAdmins);
	}

	@Override
	public void removeStudent(Integer id) {
		studentsRepository.deleteById(id);
		
	}

	@Override
	public void removeLibAdmin(Integer id) {
		libAdminsRepository.deleteById(id);
		
	}

	@Override
	public Books addBooks( Books books) {
		return booksRepository.save(books);
	}

	@Override
	public void removeBook(Integer id) {
		booksRepository.deleteById(id);
		
	}
	
	public List<String> borrowedBooksList()
	{
		return libAdminsRepository.booksBorrowedList();
	}
	
	public List<String> booksBorrowedByOneStudent(Integer id)
	{
		return libAdminsRepository.booksBorrowedByOneStudent(id);
	}
	public List<String> bookBorrowedByManyStudents(Integer id)
	{
		return libAdminsRepository.bookBorrowedByManyStudents(id);
	}
	public Integer getAdminId (String name)
	{
		return libAdminsRepository.getAdminId(name);
	}
	
	@Override
	public List<LibAdmins> getAll() {
		
		return libAdminsRepository.findAll();
	}
	
	
	
}
