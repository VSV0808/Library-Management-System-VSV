package com.vsv.libManagSys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsv.libManagSys.model.Students;
import com.vsv.libManagSys.repository.BooksRepository;
import com.vsv.libManagSys.repository.DatesRepository;
import com.vsv.libManagSys.repository.StudentsRepository;

@Service
public class StudentsServiceImpl implements StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private DatesRepository datesRepository;

	@Override
	public List<Students> getAllStudents() {
		return studentsRepository.findAll();
	}

	@Override
	public Students saveStudent(Students student) {
		
		return studentsRepository.save(student);
	}



	public Integer borrowBook(String bookName)
	{
		return booksRepository.bookName(bookName);
	}
	
	public Optional<Students> getStudent(Integer id)
	{
		
		return studentsRepository.findById(id);
	}
	public String getName(Integer id)
	{
		return studentsRepository.getNameOfStudent(id);
	}
	public Integer getQty(String bookName)
	{
		return booksRepository.bookQty(bookName);
	}
	public void deleteData(Integer rollNo,Integer id)
	{
		datesRepository.deleteData(rollNo, id);
	}
	public void deleteDataOfReturn(Integer id,Integer id1 )
	{
		studentsRepository.deleteRelationalTableData(id, id1);
	}

}
