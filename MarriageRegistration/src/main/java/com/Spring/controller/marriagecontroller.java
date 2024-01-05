package com.Spring.controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Spring.Response.response;
import com.Spring.model.Marriagedata;
import com.Spring.model.imageentity;
import com.Spring.repository.imagerepo;
import com.Spring.repository.marriagerepo;
import com.Spring.serviceimpl.marriageserviceimpl;

@RestController
public class marriagecontroller {

	@Autowired
	private marriageserviceimpl marriageservice;
	@Autowired
	private marriagerepo mrepo;
	long id1;


	 @PostMapping("/savedetail")
	    public ResponseEntity<response> saveData(@RequestBody Marriagedata srlmbankdetails) throws IOException {
	  
	    	
	    	  response resp = new response(); 
	    marriageservice.savedata(srlmbankdetails,id1) ;
	    	resp.setCode(HttpStatus.OK);
			resp.setMessage("data save successfully");
			resp.setObject(srlmbankdetails);
	    	

			return ResponseEntity.ok().body(resp);
	    }
	    
	    @PutMapping("/api/persons/{personId}")
	    public ResponseEntity<Marriagedata> updatePerson(@PathVariable Long personId, @RequestBody Marriagedata updatedPerson) {
	    	//id1=personId;
	        Optional<Marriagedata> personOptional = mrepo.findById(personId);
	        return personOptional.map(person -> {
	            person.setFirstname(updatedPerson.getFirstname());
	            person.setMobileno(updatedPerson.getMobileno());
	            person.setDob(updatedPerson.getDob());
	            person.setAge(updatedPerson.getAge());
	            person.setMarritalstatus(updatedPerson.getMarritalstatus());
	            person.setDistrict(updatedPerson.getDistrict());
	            person.setGender(updatedPerson.getGender());
	            person.setArea(updatedPerson.getArea());
	            person.setBlock(updatedPerson.getBlock());
	            person.setCity(updatedPerson.getCity());
	            person.setVillage(updatedPerson.getVillage());
	       
	            
	           person.setLocality(updatedPerson.getLocality());
	           
	            person.setEmail(updatedPerson.getEmail());
	           mrepo.save(person);
	           /*
	            Optional<Marriagedata> personOptional2(long id);
	            
	            
	            
	            */
	           
	           
	           
	           
	           
	           
	            return new ResponseEntity<>(person, HttpStatus.OK);
	        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	  
	    
	

	    

	    @GetMapping("/api")
	    public List<Marriagedata> getAllUsers() {
	        return marriageservice.getAllUsers();
	    }
	    @GetMapping("/api/images/{id}")
	    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
	        imageentity imageEntity = marriageservice.getImageById(id);

	        if (imageEntity != null) {
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust the media type based on your image type

	            return new ResponseEntity<>(imageEntity.getImageData(), headers, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    
	    }
	    @GetMapping("/api/persons/{id}")
        public ResponseEntity<Marriagedata> getPersonById(@PathVariable Long id) {
	    	id1=id;
           // Optional<Marriagedata> person = mrepo.findById(id);
            Optional<Marriagedata> person=marriageservice.person(id);
            return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
	    @PostMapping("/api/persons")
	    public ResponseEntity<Marriagedata> savePerson(@RequestBody Marriagedata person) {
	    	  Marriagedata savedPerson=new Marriagedata();
	    	  savedPerson.setFlag(0);
	    	  savedPerson=person;
	    	 // Marriagedata savedPerson2 = mrepo.save(savedPerson);
	    	    Marriagedata savedPerson3 = marriageservice.savedPerson2(savedPerson);
	        return ResponseEntity.ok(savedPerson);
	    }

		
}
