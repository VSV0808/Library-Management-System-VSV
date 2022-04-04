package com.vsv.libManagSys.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vsv.libManagSys.model.Dates;

public interface DatesRepository extends JpaRepository<Dates, Integer> {
	
	@Query(value = "select due_date from dates where rol_no=?1",nativeQuery = true)
	public Date getDueDate(Integer id);
	@Query(value="select * from dates where roll_no=?1 ",nativeQuery = true)
	public List<Dates> getDatesData(Integer id);
	@Transactional
	@Modifying
	@Query(value = "delete from dates where roll_no=?1 and book_id=?2 limit 1",nativeQuery = true)
	public void deleteData(Integer rollNo,Integer id);
	

	
}
