package com.vsv.libManagSys.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vsv.libManagSys.model.Books;
import com.vsv.libManagSys.model.Dates;
import com.vsv.libManagSys.model.Students;
import com.vsv.libManagSys.service.BookServiceImpl;
import com.vsv.libManagSys.service.DatesServiceImpl;
import com.vsv.libManagSys.service.StudentsServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentsController {
	
	@Autowired
	private StudentsServiceImpl studentsServiceImpl;
	
	@Autowired
	private BookServiceImpl booksServiceImpl;

	@Autowired
	private DatesServiceImpl datesServiceImpl;
	
	@GetMapping("/getAll")
	public List<Students> getAllStudents()
	{
		
		return studentsServiceImpl.getAllStudents();
	
	}

	@PostMapping("/addStudent")
	public void saveStudents(@RequestBody Students students)
	{
		studentsServiceImpl.saveStudent(students);
	}
	
	@PostMapping("/borrowBook")
	public boolean borrowBook(@RequestBody ObjectNode objectNode)
	{
	
		int slot_no=1;
		int id=objectNode.get("rollNo").asInt();
		String name=objectNode.get("book_Name").asText();
		int book_id=studentsServiceImpl.borrowBook(name);
		if(studentsServiceImpl.getQty(name)>0)
		{Books books=new Books(book_id,name,studentsServiceImpl.getQty(name));
		Optional<Students> students=studentsServiceImpl.getStudent(id);
		List<Books> booksList= students.map(Students::getBooksOfStudents).orElse(null);
		booksList.add(books);
		Students stu1=new Students(id,studentsServiceImpl.getName(id),booksList);
		Books books2=new Books(book_id,name,(studentsServiceImpl.getQty(name)-1));
		booksServiceImpl.saveBook(books2);
		saveStudents(stu1);
		Date currDate=new Date(System.currentTimeMillis());
		Date dueDate=new Date(System.currentTimeMillis()+604800000);
		Dates dates=new Dates(slot_no,id,book_id,currDate,dueDate);
		datesServiceImpl.saveDatesData(dates);
		return true;}
		else
			return false;
	}
	@PostMapping("/returnBook")
	public void returnBook(@RequestBody ObjectNode objectNode)
	{
		int id=objectNode.get("rollNo").asInt();
		String name=objectNode.get("book_Name").asText();
		int book_id=studentsServiceImpl.borrowBook(name);
		Books books=new Books(book_id,name,studentsServiceImpl.getQty(name));
		Optional<Students> students=studentsServiceImpl.getStudent(id);
		List<Books> booksList= students.map(Students::getBooksOfStudents).orElse(null);
		booksList.remove(books);
		Books books2=new Books(book_id,name,(studentsServiceImpl.getQty(name)+1));
		Students stu1=new Students(id,studentsServiceImpl.getName(id),booksList);
		booksServiceImpl.saveBook(books2);
		saveStudents(stu1);
		studentsServiceImpl.deleteData(id, book_id);
		studentsServiceImpl.deleteDataOfReturn(id, book_id);
		
	}
	
	@GetMapping("/getName/{id}")
	public String getStudentName(@PathVariable Integer id)
	{
		return studentsServiceImpl.getName(id);
	}
	
	
	

	
	


	

}
