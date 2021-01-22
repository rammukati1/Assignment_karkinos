package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PatientsRepo;
import com.example.demo.entity.Patients;

@RestController
public class NameController {

	@Autowired
	PatientsRepo repo;
	 @GetMapping("/name/{name}")
	    public List<Patients> showSignUpForm(@PathVariable ("name") String name , Model model) {
		 List<Patients> Patient = new ArrayList<>();
			repo.findAll().forEach(Patient::add);
	   ;
//	      model.addAttribute("list", p);
		  return Patient;
	    }
}
