package com.hibernate.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Medical {
	@Id
	private Integer medicationID;
	private String name;
	private Integer dosage;
	private LocalDate MFD;
	private LocalDate EXD;
	private Integer price;
	
	
	//manytomany medicinesToBilling
	 @ManyToMany(mappedBy="medicalSet")
	Set<Billing> billingSet=new HashSet<Billing>();
	 
	
	public Medical() {
		
	}
	
	

	public Set<Billing> getBillingSet() {
		return billingSet;
	}




	public void setBillingSet(Set<Billing> billingSet) {
		this.billingSet = billingSet;
	}




	public Integer getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(Integer medicationID) {
		this.medicationID = medicationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDosage() {
		return dosage;
	}

	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}

	public LocalDate getMFD() {
		return MFD;
	}

	public void setMFD(LocalDate mFD) {
		MFD = mFD;
	}

	public LocalDate getEXD() {
		return EXD;
	}

	public void setEXD(LocalDate eXD) {
		EXD = eXD;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String toString() {
		return "Medical [medicationID="+medicationID+", name="+name+", dosage="+dosage+", MFD="+MFD+", EXD="+EXD+", price="+price+", billingSet="+billingSet+"]";
		
	}
}
