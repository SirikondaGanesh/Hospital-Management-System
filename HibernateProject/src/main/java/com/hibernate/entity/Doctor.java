package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Doctor {
	@Id
	private Integer doctorID;
	private String name;
	private String specialty;
	private Long phoneNo;
	private String availabilitySchedule;
	
	@OneToOne(targetEntity = Receptionist.class,cascade = CascadeType.ALL)
	private Receptionist receptionist;
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	List<Treatments> treatments=new ArrayList<Treatments>();
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	List<Nurse> nurse=new ArrayList<Nurse>();
	
	public Doctor() {
		
	}
	
	
	public Receptionist getReceptionist() {
		return receptionist;
	}


	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}


	public List<Treatments> getTreatments() {
		return treatments;
	}


	public void setTreatments(List<Treatments> treatments) {
		this.treatments = treatments;
	}


	public List<Nurse> getNurse() {
		return nurse;
	}


	public void setNurse(List<Nurse> nurse) {
		this.nurse = nurse;
	}
	public Integer getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSpecialty() {
		return specialty;
	}



	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}



	public Long getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getAvailabilitySchedule() {
		return availabilitySchedule;
	}



	public void setAvailabilitySchedule(String availabilitySchedule) {
		this.availabilitySchedule = availabilitySchedule;
	}



	@Override
	public String toString() {
		return "Doctor [doctorID="+doctorID+", name="+name+", specialty="+specialty+",phoneNo="+phoneNo+", Availability-Schedule="+availabilitySchedule+", receptionist="+receptionist+", treatments="+treatments+", nurse="+nurse+"]";
	}
}
