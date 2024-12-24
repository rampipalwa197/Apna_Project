package com.apna.student.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apna.student.model.Student;
import com.apna.student.repository.Student_Repository;
import com.apna.student.service.Student_Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Student_ServiceImpl implements Student_Service{

	@Autowired
	private Student_Repository repository;
	
	@Override
	public Student add(String json, MultipartFile photo) {
		
		ObjectMapper om=new ObjectMapper();
		Student st=null;
		
		try {
			st=om.readValue(json, Student.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(st!=null)
		{
			try {
				st.setPhoto(photo.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return repository.save(st); 
	}

	@Override
	public Student getStu(int id) {
		Optional<Student> opst=repository.findById(id);
		Student st=opst.get();
		return st;
	}

	@Override
	public List<Student> getAllStu() {
	    List<Student> list = repository.findAll();
		return list;
	}

	@Override
	public Student updateStu(int id, String json, MultipartFile ph) {
		Optional<Student> opst = repository.findById(id);
		Student s=null;
		
		if(opst.isPresent())
		{
			Student st=opst.get();
			
			ObjectMapper mapper=new ObjectMapper();
			
			try {
				s=mapper.readValue(json, Student.class);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ph!=null)
				try {
					s.setPhoto(ph.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(s.getName()!=null)
			st.setName(s.getName());
			
			if(s.getEmail()!=null)
				st.setEmail(s.getEmail());
			
			if(s.getContact()!=0)
				st.setContact(s.getContact());
			
			if(s.getDegree()!=null)
				st.setDegree(s.getDegree());
			
			if(s.getAddress()!=null)
				st.setAddress(s.getAddress());
			
			if(s.getPhoto()!=null)
				st.setPhoto(s.getPhoto());
			
			return repository.save(st);
		}
		else
		{
			throw new RuntimeException("Record not found!!");
		}
		
	}

}
