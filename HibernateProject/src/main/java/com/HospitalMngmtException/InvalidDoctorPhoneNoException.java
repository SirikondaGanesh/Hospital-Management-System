package com.HospitalMngmtException;

//Custom exception class to handle invalid phone numbers for doctors
public class InvalidDoctorPhoneNoException extends Exception{
	
	 // Constructor that accepts a custom error message
    public InvalidDoctorPhoneNoException(String message) {
        super(message);  // Pass the message to the superclass (Exception)
    }
}
