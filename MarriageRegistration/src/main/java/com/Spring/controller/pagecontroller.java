package com.Spring.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.Spring.model.Marriagedata;
import com.Spring.model.imageentity;
import com.Spring.repository.marriagerepo;
import com.Spring.serviceimpl.marriageserviceimpl;

@Controller
public class pagecontroller {
	@Autowired
	private marriageserviceimpl marriageservice;
	@Autowired
	private marriagerepo mrepo;
	@GetMapping("/")
	public String open() {
		return "index";
	}
	@PostMapping("/upload")
	public String image(@RequestParam("image") MultipartFile file) throws IOException {
		
		imageentity saved = marriageservice.saveImage(file);
	

		return "redirect:/";
		
		
		
	}  
	 @GetMapping("/showFormUpdate/{id}")
		public String showFormUpdate(@PathVariable (value="id" ) long id, Model m) {
	Marriagedata stu=marriageservice.getDataById(id);

	return "reviewPage";
		}
	 @GetMapping("/review")
	 public String review() {
		 return "reviewPage";
	 }
	 @GetMapping("/table")
	 public String table(){
		 return "mainfile";
	 }
	 
		 
	 @GetMapping("/home")
	 public String about(){
		 return "About";
	 }

}
