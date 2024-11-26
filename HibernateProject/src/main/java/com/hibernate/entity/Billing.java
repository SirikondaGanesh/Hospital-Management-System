package com.hibernate.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Billing {
	@Id
	private Integer billingID;
	private LocalDate billingDate;
	private String paymentMethod;
	private Integer totalAmount;
	private String paymentStatus;
	private Long phoneNo;
	
	//change it to manyToone
	
	 @ManyToOne
	@JoinColumn(name="patientID")
	private Patients patients;
	 
	 
	  @ManyToMany
	@JoinTable(name="Medicines_Billing",joinColumns=@JoinColumn(name="billingID"),inverseJoinColumns=@JoinColumn(name="medicationID"))
	Set<Medical> medicalSet=new HashSet<Medical>();
	  
	  
	public Billing() {
		
	}
	
	
	public Set<Medical> getMedicalSet() {
		return medicalSet;
	}


	public void setMedicalSet(Set<Medical> medicalSet) {
		this.medicalSet = medicalSet;
	}


	public Patients getPatients() {
		return patients;
	}
	public void setPatients(Patients patients) {
		this.patients = patients;
	}
	public Integer getBillingID() {
		return billingID;
	}
	public void setBillingID(Integer billingID) {
		this.billingID = billingID;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String toString() {
		return "Billing [billingID="+billingID+", billingDate="+billingDate+", paymentMethod="+paymentMethod+", totalAmount="+totalAmount+", paymentStatus="+paymentStatus+", phoneNo="+phoneNo+", patients="+patients+", medicalSet="+medicalSet+"]";
		
	}
}
