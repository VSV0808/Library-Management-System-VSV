package com.vsv.libManagSys.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsv.libManagSys.model.Dates;
import com.vsv.libManagSys.repository.DatesRepository;

@Service
public class DatesServiceImpl implements DatesService {
	
	@Autowired
	private DatesRepository datesRepository;

	@Override
	public Dates saveDatesData(Dates dates) {
	
		return datesRepository.save(dates) ;
	}
	
	public Date getDueDate(Integer rollNo)
	{
		return datesRepository.getDueDate(rollNo);
	}
	public List<Dates> getDatesData(Integer id)
	{
		return datesRepository.getDatesData(id);
	}
	
	
	

}
