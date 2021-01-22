package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Patients;

public interface PatientsRepo  extends CrudRepository <Patients , Long>{
 
	
	public  List<Patients> findByName(String name);

}