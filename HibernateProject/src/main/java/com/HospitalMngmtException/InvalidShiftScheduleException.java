package com.HospitalMngmtException;

//Step 1: Create a custom exception class
public class InvalidShiftScheduleException extends Exception {
	  // Constructor
    public InvalidShiftScheduleException(String message) {
        super(message);
    }

}
