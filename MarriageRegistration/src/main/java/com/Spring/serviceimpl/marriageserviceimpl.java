package com.Spring.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.Spring.model.Marriagedata;
import com.Spring.model.imageentity;
import com.Spring.repository.imagerepo;
import com.Spring.repository.marriagerepo;
import com.Spring.service.marriageservice;

@Service
public class marriageserviceimpl implements marriageservice{
	  @Autowired
	    private imagerepo imageRepository;
	@Autowired
	private marriagerepo mrepo;
	
imageentity image2=new imageentity();
@Override
public imageentity saveImage(MultipartFile file) throws IOException {
	   imageentity image = new imageentity();
     image.setImageName(file.getOriginalFilename());
     image.setImageData(file.getBytes());
     this.image2=image;

	return null;
}
@Override
public List<Marriagedata> getAllUsers() {
	long f=1;
    return mrepo.getByFlag(f);
}
@Override
	public Marriagedata savedata(Marriagedata m,long id) {
		  try {
	            // Introduce a delay of 3000 milliseconds (3 seconds)
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // Handle the exception
	            e.printStackTrace();
	        }
		Marriagedata main=new Marriagedata();
		
	main=m;
	main.setFlag(1);
	main.setId(id);
		main.setImage(image2);
		this.mrepo.save(main);
		//imageRepository.save(image2);

		return this.mrepo.save(main); 
	}
@Override
	  public imageentity getImageById(Long id) {
	        return imageRepository.findById(id).orElse(null);
	    }
@Override
	  public Marriagedata  getDataById(long id) {
			Optional<Marriagedata> optional=mrepo.findById(id);
			Marriagedata stu=null;
			if(optional.isPresent()) {
				stu=optional.get();
				
			}
			else {
				throw new RuntimeException("Data not found by id");
			}
		return stu;

		}

@Override
  public Marriagedata savedPerson2(Marriagedata s){
  
 
  return this.mrepo.save(s);
  }
	   @Override
	   public Optional<Marriagedata> person(long id){
	   return this.mrepo.findById(id);
	   
	   
	   }
	   @Override
	   public  Marriagedata update( long personId,Marriagedata updatedPerson ){
			/*
			 * Optional<Marriagedata> personOptional = mrepo.findById(personId); return
			 * personOptional.map(person -> {
			 * person.setFirstname(updatedPerson.getFirstname());
			 * person.setMobileno(updatedPerson.getMobileno());
			 * person.setDob(updatedPerson.getDob()); person.setAge(updatedPerson.getAge());
			 * person.setMarritalstatus(updatedPerson.getMarritalstatus());
			 * person.setDistrict(updatedPerson.getDistrict());
			 * person.setGender(updatedPerson.getGender());
			 * person.setArea(updatedPerson.getArea());
			 * person.setBlock(updatedPerson.getBlock());
			 * person.setCity(updatedPerson.getCity());
			 * person.setVillage(updatedPerson.getVillage());
			 * 
			 * 
			 * person.setLocality(updatedPerson.getLocality());
			 * 
			 * person.setEmail(updatedPerson.getEmail()); mrepo.save(person); return person;
			 * 
			 * 
			 * 
			 * });
			 */
	        	return null;	
 
	   }
 
 
 
 
 
 


	
	}




