package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PatientsRepo;
import com.example.demo.entity.Patients;
import com.example.demo.model.Patient_model;
import com.example.demo.service.PatientsService;

@Controller
public class ResourceController {
	
	@Autowired 
	PatientsService patientsService;
	@Autowired 
	PatientsRepo repo;
	
	
	@GetMapping(path = "/patients")
		public String getAllPatients( Model model) {
			model.addAttribute("listPatients", patientsService.getAllPatients());
			return "index";
		}
	
	@GetMapping("/add")
	    public String showSignUpForm(Patients patients) {
	        return "add-user";
	    }


	@PostMapping("addData")
		public String addStudent(@Validated Patients patients, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        repo.save(patients);
        return "success";
		}

	
	@GetMapping("delete/{id}")
	   public String deleteStudent(@PathVariable("id") long id, Model model) {
	       Patients patient = repo.findById(id).orElse(null);
	       repo.delete(patient);
	        model.addAttribute("listPatients", repo.findAll());
	        return "index";
	    }
	    
	    
	@GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Patients patient = repo.findById(id)
	            .orElseThrow(null);
	        model.addAttribute("patient", patient);
	        return "update";
	    }
	    
	
	    @PostMapping("/update/{id}")
	    public String updateStudent(@PathVariable("id") long id, @Validated Patients patient, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	        	patient.setId(id);
	            return "update";
	        }

	        repo.save(patient);
	        model.addAttribute("listPatients", repo.findAll());
	        return "index";
	    }

}