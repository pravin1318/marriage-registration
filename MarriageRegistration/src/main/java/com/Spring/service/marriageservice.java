package com.Spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.Spring.model.Marriagedata;
import com.Spring.model.imageentity;

public interface marriageservice {

	public imageentity saveImage(MultipartFile file)throws IOException;
	public List<Marriagedata> getAllUsers();
	public Marriagedata savedata(Marriagedata m,long id);
	  public imageentity getImageById(Long id);
	  public Marriagedata  getDataById(long id);
	  
	   public Marriagedata savedPerson2(Marriagedata s);
	   
	   public Optional<Marriagedata> person(long id);
	   public  Marriagedata update( long personId,Marriagedata updatedPerson);
	   
	   
	   
}
