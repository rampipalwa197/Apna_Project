package com.apna.admin.serviceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apna.admin.model.Admin;
import com.apna.admin.repository.Admin_Repository;
import com.apna.admin.service.Admin_Service;

@Service
public class Admin_ServiceImpl implements Admin_Service{

	@Autowired
	private Admin_Repository repository;
	

	@Override
	public Admin addAdmin(Admin ad) {
		
		Random random =new Random(1000);
		String name=ad.getName();
		ad.setUsername(name+random.nextInt(9999));
		ad.setPassword(name+"@"+random.nextInt(9999));
		return repository.save(ad);
	}
	
	
	@Override
	public String getAllStu(String stuDetails) {
		
		return stuDetails;
	}
}
