package com.hibernate.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Treatments {
	@Id
	private Integer treatmentID;
	private LocalDate treatmentDate;
	private String treatmentName;
	private boolean  followUpRequired; // true for Yes, false for No
	private Integer treatmentCost;
	
	@ManyToOne
	@JoinColumn(name="doctorID")
	private Doctor doctor;
	
	@ManyToMany(mappedBy="treatmentsSet")
	Set<Patients> patientsSet=new HashSet<Patients>();
	
	public Treatments() {
		
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



	public Integer getTreatmentID() {
		return treatmentID;
	}


	public void setTreatmentID(Integer treatmentID) {
		this.treatmentID = treatmentID;
	}


	public LocalDate getTreatmentDate() {
		return treatmentDate;
	}


	public void setTreatmentDate(LocalDate treatmentDate) {
		this.treatmentDate = treatmentDate;
	}


	public String getTreatmentName() {
		return treatmentName;
	}


	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}


	public boolean isFollowUpRequired() {
		return followUpRequired;
	}


	public void setFollowUpRequired(boolean followUpRequired) {
		this.followUpRequired = followUpRequired;
	}


	public Integer getTreatmentCost() {
		return treatmentCost;
	}


	public void setTreatmentCost(Integer treatmentCost) {
		this.treatmentCost = treatmentCost;
	}


	@Override
	public String toString() {
		return "Treatments [treatmentID="+treatmentID+", treatmentDate="+treatmentDate+", treatmentName="+treatmentName+", followUpRequired="+followUpRequired+", treatmentCost="+treatmentCost+", doctor="+doctor+", patientsSet="+patientsSet+"]";
		
	}
}
