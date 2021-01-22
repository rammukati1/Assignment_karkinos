package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patients {
	
	@Override
	public String toString() {
		return "Patients [id=" + id + ", name=" + name + ", gender=" + gender + ", mobileNo=" + mobileNo + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	String name;
	String gender;
	public Patients( String name, String gender, String mobileNo) {
		super();
	
		this.name = name;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}
	public Patients() {
		super();	
	}
	String mobileNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
