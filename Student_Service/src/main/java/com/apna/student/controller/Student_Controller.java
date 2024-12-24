package com.apna.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apna.student.model.Student;
import com.apna.student.service.Student_Service;

@RestController
public class Student_Controller {
	
	@Autowired
	private Student_Service service;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStu(@RequestPart ("json") String json,@RequestPart ("ph") MultipartFile photo)
	{
		Student s=service.add(json,photo);
		return new ResponseEntity<Student>(s, HttpStatus.CREATED);
	}
	
	@GetMapping("/getStu/{id}")
	public ResponseEntity<Student> getSingleStu(@PathVariable int id)
	{
		Student s=service.getStu(id);
		return new ResponseEntity<Student>(s, HttpStatus.OK);
	}
	
	@GetMapping("/getStu")
	public ResponseEntity<List<Student>> getAllStu()
	{
		List<Student> s=service.getAllStu();
		return new ResponseEntity<List<Student>>(s, HttpStatus.OK);
	}
	
	@PutMapping("/updateStu/{id}")
	public ResponseEntity<Student> updateStu(@RequestPart ("json") String json,@PathVariable int id,@RequestPart(value = "ph",required = false) MultipartFile ph)
	{
		Student st=service.updateStu(id,json,ph);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}

}
