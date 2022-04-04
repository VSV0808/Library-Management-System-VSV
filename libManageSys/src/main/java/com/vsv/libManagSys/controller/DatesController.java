package com.vsv.libManagSys.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsv.libManagSys.model.Dates;
import com.vsv.libManagSys.repository.DatesRepository;
import com.vsv.libManagSys.service.DatesServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/datesData")
public class DatesController {
	
	@Autowired
	private DatesRepository datesRepository;
	@Autowired
	private DatesServiceImpl dateServiceImpl;
	
	
	@GetMapping("/getDatesData")
	public List<Dates> getDatesData()
	{
		return datesRepository.findAll();
	}
	@GetMapping("/getDatesData/{id}")
	public List<Dates> getDatesData(@PathVariable Integer id)
	{
		return dateServiceImpl.getDatesData(id);
	}
	@GetMapping("/currDate")
	public Date currDate()
	{
		return new Date(System.currentTimeMillis());
	}
}

