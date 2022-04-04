package com.vsv.libManagSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vsv.libManagSys.model.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	@Query(value="select book_id from books where book_name=?1",nativeQuery = true)
	public Integer bookName(String bookName);
	
	@Query(value="select qty from books where book_name=?1",nativeQuery = true)
	public Integer bookQty(String bookName);
}
