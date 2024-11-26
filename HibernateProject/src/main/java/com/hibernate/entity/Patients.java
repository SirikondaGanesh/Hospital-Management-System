package com.hibernate.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Patients {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patientID;
	private String name;
	private Integer age;
	private String gender;
	private String diagnosis;
	private Long phoneNo;
	private String address;
	
	@ManyToMany
	@JoinTable(name="Patients_Nurse",joinColumns=@JoinColumn(name="patientID"),inverseJoinColumns=@JoinColumn(name="nurseID"))
	Set<Nurse> nurseSet=new HashSet<Nurse>();
	
	@ManyToOne
	@JoinColumn(name="receptionistID")
	private Receptionist receptionist;
	
	@ManyToMany
	@JoinTable(name="Patients_Treatments",joinColumns=@JoinColumn(name="patientID"),inverseJoinColumns=@JoinColumn(name="treatmentID"))
	Set<Treatments> treatmentsSet=new HashSet<Treatments>();
	
	@ManyToMany
	@JoinTable(name="Patients_HsptlRoom",joinColumns=@JoinColumn(name="patientID"),inverseJoinColumns=@JoinColumn(name="roomID"))
	Set<HsptlRoom> hsptlRoomSet=new HashSet<HsptlRoom>();
	
	
	
	 @OneToMany(mappedBy="patients",cascade = CascadeType.ALL)
	List<Billing> billing=new ArrayList<Billing>();

	 
	
	
	public Set<Nurse> getNurseSet() {
		return nurseSet;
	}

	public void setNurseSet(Set<Nurse> nurseSet) {
		nurseSet = nurseSet;
	}

	public Receptionist getReceptionist() {
		return receptionist;
	}

	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	public Set<Treatments> getTreatmentsSet() {
		return treatmentsSet;
	}

	public void setTreatmentsSet(Set<Treatments> treatmentsSet) {
		treatmentsSet = treatmentsSet;
	}

	public Set<HsptlRoom> getHsptlRoomSet() {
		return hsptlRoomSet;
	}

	public void setHsptlRoomSet(Set<HsptlRoom> hsptlRoomSet) {
		hsptlRoomSet = hsptlRoomSet;
	}

	public List<Billing> getBilling() {
		return billing;
	}

	public void setBilling(List<Billing> billing) {
		this.billing = billing;
	}

	public Patients() {
		
	}
	 
	public Integer getPatientID() {
		return patientID;
	}




	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Integer getAge() {
		return age;
	}




	public void setAge(Integer age) {
		this.age = age;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getDiagnosis() {
		return diagnosis;
	}




	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}




	public Long getPhoneNo() {
		return phoneNo;
	}




	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}




	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}




	@Override
	public String toString() {
		return "Patients [patientID="+patientID+", Name="+name+", Age="+age+", Gender="+gender+", Diagnosis="+diagnosis+", phoneNo="+phoneNo+", Address="+address+", nurseSet="+nurseSet+", receptionist="+receptionist+", treatmentsSet="+treatmentsSet+", hsptlRoomSet="+hsptlRoomSet+", billing="+billing+"]";
		
	}
}
