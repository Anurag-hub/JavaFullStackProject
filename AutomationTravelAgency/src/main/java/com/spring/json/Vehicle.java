package com.spring.json;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
public class Vehicle 
{ 
	private long vehicleId; 
	private String  name; 
	private String type; 
	private String registrationNumber; 
	private int seatingCapacity; 
	private int farePerKm;
	@OneToMany(cascade={CascadeType.PERSIST}, 
			fetch=FetchType.LAZY, mappedBy = "userCredentialsEntity")
	private Set<Reservation> reservationList;
	
	public Vehicle() {
		super(); 
	}
	
	public Vehicle(long vehicleId, String name, String type, String registrationNumber, int seatingCapacity,
			int farePerKm) {
		super();
		this.vehicleId = vehicleId;
		this.name = name;
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
	}
	
	public Vehicle(  String name, String type, String registrationNumber, int seatingCapacity,
			int farePerKm) {
		super(); 
		this.name = name;
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
	}

	public Vehicle(long vehicleId, String name, String type, String registrationNumber, int seatingCapacity,
			int farePerKm, Set<Reservation> reservationList) {
		super();
		this.vehicleId = vehicleId;
		this.name = name;
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.reservationList = reservationList;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(int farePerKm) {
		this.farePerKm = farePerKm;
	}

	public Set<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(Set<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", name=" + name + ", type=" + type + ", registrationNumber="
				+ registrationNumber + ", seatingCapacity=" + seatingCapacity + ", farePerKm=" + farePerKm
				+ ", reservationList=" + reservationList + "]";
	}
	
	
	 
}