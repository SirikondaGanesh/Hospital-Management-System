package com.hibernate.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Receptionist {
	@Id
	private Integer receptionistID;
	private String name;
	private Long phoneNo;
	private Date hireDate;
	private String shiftSchedule;
	private Integer Salary;

	@OneToMany(mappedBy="receptionist",cascade=CascadeType.ALL)
	List<Patients> patients=new ArrayList<Patients>();
	
	@OneToOne(targetEntity = Doctor.class,cascade = CascadeType.ALL)
	private Doctor doctor;
	public Receptionist() {
		
	}
	
	
	
	public List<Patients> getPatients() {
		return patients;
	}



	public void setPatients(List<Patients> patients) {
		this.patients = patients;
	}



	public Doctor getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public Integer getReceptionistID() {
		return receptionistID;
	}


	public void setReceptionistID(Integer receptionistID) {
		this.receptionistID = receptionistID;
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


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date date) {
		this.hireDate = date;
	}


	public String getShiftSchedule() {
		return shiftSchedule;
	}


	public void setShiftSchedule(String shiftSchedule) {
		this.shiftSchedule = shiftSchedule;
	}


	public Integer getSalary() {
		return Salary;
	}


	public void setSalary(Integer salary) {
		Salary = salary;
	}


	@Override
	public String toString() {
		return "Receptionist [ReceptionistID="+receptionistID+", Name="+name+", PhoneNo="+phoneNo+", Hire-Date="+hireDate+", Shift-Schedule="+shiftSchedule+", Salary="+Salary+", patients="+patients+", doctor="+doctor+"]";
	}
	
}
