package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class HsptlRoom {
	@Id
	private Integer roomID;
	private String roomType;
	private Integer capacity;
	private boolean occupiedStatus; //true for Yes, false for No
	private Integer cost;
	
	@ManyToMany(mappedBy="hsptlRoomSet")
	Set<Patients> patientsSet=new HashSet<Patients>();
	
	@ManyToMany(mappedBy="hsptlRoomSet")
	Set<Nurse> nursesSet=new HashSet<Nurse>();
	
	public HsptlRoom() {
		
	}
	
	
	public Set<Patients> getPatientsSet() {
		return patientsSet;
	}


	public void setPatientsSet(Set<Patients> patientsSet) {
		this.patientsSet = patientsSet;
	}


	public Set<Nurse> getNursesSet() {
		return nursesSet;
	}


	public void setNursesSet(Set<Nurse> nursesSet) {
		this.nursesSet = nursesSet;
	}


	public Integer getRoomID() {
		return roomID;
	}



	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public Integer getCapacity() {
		return capacity;
	}



	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}



	public boolean isOccupiedStatus() {
		return occupiedStatus;
	}



	public void setOccupiedStatus(boolean occupiedStatus) {
		this.occupiedStatus = occupiedStatus;
	}



	public Integer getCost() {
		return cost;
	}



	public void setCost(Integer cost) {
		this.cost = cost;
	}



	@Override
	public String toString() {
		return "HsptlRoom [roomID="+roomID+", roomType="+roomType+", capacity="+capacity+", occupiedStatus="+occupiedStatus+", cost="+cost+", patientsSet="+patientsSet+", nursesSet="+nursesSet+"]";
		
	}
}
