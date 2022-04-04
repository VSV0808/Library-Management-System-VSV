package com.vsv.libManagSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vsv.libManagSys.model.LibAdmins;

public interface LibAdminsRepository extends JpaRepository<LibAdmins, Integer> {

	@Query(value="select book_name from books as b,books_students as sb where sb.book_id=b.book_id",nativeQuery = true)
	List<String> booksBorrowedList();
	@Query(value="select books.book_name from students join books_students on students.roll_no=books_students.roll_no join books on books.book_id=books_students.book_id where students.roll_no=?1",nativeQuery = true)
	List<String> booksBorrowedByOneStudent(Integer id);
	@Query(value="select students.student_name from students join books_students on students.roll_no=books_students.roll_no join books on books.book_id=books_students.book_id where books.book_id=?1",nativeQuery = true)
	List<String> bookBorrowedByManyStudents(Integer id);
	@Query(value="select admin_id from lib_admins where admin_name=?1",nativeQuery = true)
	Integer getAdminId(String name);
}
