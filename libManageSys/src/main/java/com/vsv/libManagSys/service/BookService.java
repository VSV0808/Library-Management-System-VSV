package com.vsv.libManagSys.service;

import java.util.List;

import com.vsv.libManagSys.model.Books;


public interface BookService {
	
	public Books saveBook(Books book);
	public List<Books> getAllBooks();

}
