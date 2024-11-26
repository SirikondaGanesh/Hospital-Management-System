package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Nurse {
    @Id
	private Integer nurseID; 
	private String name;
	private Long phoneNo;
	private Integer salary;
	
	@ManyToOne
	@JoinColumn(name="doctorID")
	private Doctor doctor;
	
	@ManyToMany(mappedBy="nurseSet")
	Set<Patients> patientsSet=new HashSet<Patients>();
	
	@ManyToMany
	@JoinTable(name="Nurse_HsptlRoom",joinColumns=@JoinColumn(name="nurseID"),inverseJoinColumns=@JoinColumn(name="roomID"))
	Set<HsptlRoom> hsptlRoomSet=new HashSet<HsptlRoom>();
	
	public Nurse() {
		
	}
	
	public Set<HsptlRoom> getHsptlRoomSet() {
		return hsptlRoomSet;
	}




	public void setHsptlRoomSet(Set<HsptlRoom> hsptlRoomSet) {
		this.hsptlRoomSet = hsptlRoomSet;
	}




	public Doctor getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public Set<Patients> getPatientsSet() {
		return patientsSet;
	}



	public void setPatientsSet(Set<Patients> patientsSet) {
		this.patientsSet = patientsSet;
	}



	public Integer getNurseID() {
		return nurseID;
	}


	public void setNurseID(Integer nurseID) {
		this.nurseID = nurseID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public String toString() {
		return "Nurse [nurseID="+nurseID+", name="+name+", phoneNo="+phoneNo+", salary="+salary+", hsptlRoomSet="+hsptlRoomSet+", doctor="+doctor+", patientsSet="+patientsSet+"]";
	}
}
