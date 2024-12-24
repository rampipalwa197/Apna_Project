package com.apna.student.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.apna.student.model.Student;

public interface Student_Service {

	public Student add(String json, MultipartFile photo);

	public Student getStu(int id);

	public List<Student> getAllStu();

	public Student updateStu(int id, String json, MultipartFile ph);

}
