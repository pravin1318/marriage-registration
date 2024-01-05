package com.Spring.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

@Entity
public class Marriagedata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String email;
	private String age;
	private String dob;
	private long mobileno;
	private String district;
	private String block;
	private String village;
	private String marritalstatus;
	private String area;
	private String locality;
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	private String city;
	private String gender;
	private long flag;
	  @OneToOne(cascade = CascadeType.ALL)
	   @JoinColumn(name="image_id",referencedColumnName = "id")
	   private imageentity image;
	public long getId() { 
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMarritalstatus() {
		return marritalstatus;
	}
	public void setMarritalstatus(String marritalstatus) {
		this.marritalstatus = marritalstatus;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public imageentity getImage() {
		return image;
	}
	public void setImage(imageentity image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getFlag() {
		return flag;
	}
	public void setFlag(long flag) {
		this.flag = flag;
	}
	public Marriagedata(long id, String firstname, String email, String age, String dob, long mobileno, String district,
			String block, String village, String marritalstatus, String area, String city, String gender, long flag,
			imageentity image) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.age = age;
		this.dob = dob;
		this.mobileno = mobileno;
		this.district = district;
		this.block = block;
		this.village = village;
		this.marritalstatus = marritalstatus;
		this.area = area;
		this.city = city;
		this.gender = gender;
		this.flag = flag;
		this.image = image;
	}
	public Marriagedata() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
