package com.apna.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apna.admin.model.Admin;

@Repository
public interface Admin_Repository extends JpaRepository<Admin, Integer>{

}
