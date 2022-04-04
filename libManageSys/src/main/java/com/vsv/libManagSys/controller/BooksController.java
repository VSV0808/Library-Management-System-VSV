package com.vsv.libManagSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsv.libManagSys.model.Books;
import com.vsv.libManagSys.service.BookServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@PostMapping("/addBook")
	public void addBook(@RequestBody Books book)
	{
		bookServiceImpl.saveBook(book);
	}
	@GetMapping("/getAll")
	public List<Books> getAll()
	{
		return bookServiceImpl.getAllBooks();
	}

}
