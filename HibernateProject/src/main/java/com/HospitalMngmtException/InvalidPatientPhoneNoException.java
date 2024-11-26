package com.HospitalMngmtException;

public class InvalidPatientPhoneNoException extends Exception{
	
	// Default constructor
    public InvalidPatientPhoneNoException() {
        super("Invalid patient phone number.");
    }

    // Constructor that accepts a custom error message
    public InvalidPatientPhoneNoException(String message) {
        super(message);
    }

    // Constructor that accepts a custom error message and a cause
    public InvalidPatientPhoneNoException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidPatientPhoneNoException(Throwable cause) {
        super(cause);
    }

	
}
