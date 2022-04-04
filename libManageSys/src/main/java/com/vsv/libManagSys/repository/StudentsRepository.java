package com.vsv.libManagSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vsv.libManagSys.model.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
	

	@Query(value="select student_name from students where roll_no=?1",nativeQuery = true)
	public String getNameOfStudent(Integer id);
	@Transactional
	@Modifying
	@Query(value="delete from books_students where (roll_no=?1 and book_id=?2) limit 1",nativeQuery = true)
	public void  deleteRelationalTableData(Integer id,Integer id2);
	

}
