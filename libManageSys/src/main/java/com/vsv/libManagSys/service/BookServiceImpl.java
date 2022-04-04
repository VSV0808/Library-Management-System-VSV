package com.vsv.libManagSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsv.libManagSys.model.Books;
import com.vsv.libManagSys.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BooksRepository booksRepository;

	@Override
	public Books saveBook(Books book) {
		
		return booksRepository.save(book);
	}

	@Override
	public List<Books> getAllBooks() {
		
		return booksRepository.findAll();
	}
	
	

}
