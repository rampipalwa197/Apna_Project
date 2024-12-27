package com.apna.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apna.admin.model.Admin;
import com.apna.admin.service.Admin_Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Admin_Controller {
	
	@Autowired
	private Admin_Service service;
	
	
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin ad)
	{
		Admin a=service.addAdmin(ad);
		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
	}
	
	@KafkaListener(topics = "stu", groupId = "stu")
	
	@GetMapping("/getAllStu")
	public ResponseEntity<String> getAllStu(String stuDetails) {
		
		System.out.println(stuDetails);
            String allStu= service.getAllStu(stuDetails);
		return new ResponseEntity<String>(allStu,HttpStatus.OK);
	}
	

}
