package com.HospitalMngmtException;


//Custom exception for invalid treatment cost
public class InvalidTreatmentCostException extends Exception {
	 // Constructor that accepts a custom error message
    public InvalidTreatmentCostException(String message) {
        super(message);  // Pass the message to the superclass (Exception)
    }

}
