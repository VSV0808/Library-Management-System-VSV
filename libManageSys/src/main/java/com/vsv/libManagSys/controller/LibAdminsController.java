package com.vsv.libManagSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsv.libManagSys.model.Books;
import com.vsv.libManagSys.model.LibAdmins;
import com.vsv.libManagSys.model.Students;
import com.vsv.libManagSys.service.LibAdminServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/libAdmin")
public class LibAdminsController {
	
	@Autowired
	private LibAdminServiceImpl libAdminServiceImpl;
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Students students)
	{
		libAdminServiceImpl.addStudent(students);
	}
	@PostMapping("/addLibAdmin")
	public void addLibAdmin(@RequestBody LibAdmins libAdmins)
	{
		libAdminServiceImpl.addLibAdmin(libAdmins);
	}
	
	@PostMapping("/addBook")
	public void addBook(@RequestBody Books books)
	{
		libAdminServiceImpl.addBooks(books);
	}
	
	@DeleteMapping("/ByStudent/{id}")
	public void deleteByStudent(@PathVariable Integer id)
	{
		libAdminServiceImpl.removeStudent(id);
	}
	
	@DeleteMapping("/ByLibAdmin/{id}")
	public void deleteByLibAdmin( @PathVariable Integer id)
	{
		libAdminServiceImpl.removeLibAdmin(id);
	}
	@DeleteMapping("/ByBook/{id}")
	public void deleteByBook(@PathVariable Integer id)
	{
		libAdminServiceImpl.removeBook(id);
	}
	@GetMapping("/BorrowedBooksList")
	public List<String> getBorrowedBooks()
	{
		return libAdminServiceImpl.borrowedBooksList();
	}
	@GetMapping("/BooksBorrowedByAStudent/{id}")
	public List<String> booksBorrowedByAStudent(@PathVariable Integer id)
	{
		return libAdminServiceImpl.booksBorrowedByOneStudent(id);
	}
	@GetMapping("/BooksBorrowedByManyStudents/{id}")
	public List <String> booksBorrowedByManyStudents(@PathVariable Integer id)
	{
		return libAdminServiceImpl.bookBorrowedByManyStudents(id);
	}
	@GetMapping("/getAll")
	public List<LibAdmins> getAllAdmin()
	{
		return libAdminServiceImpl.getAll();
		
	}
	@GetMapping("/getId/{name}")
	public Integer getId(@PathVariable String name)
	{
		return libAdminServiceImpl.getAdminId(name);
	}
}
