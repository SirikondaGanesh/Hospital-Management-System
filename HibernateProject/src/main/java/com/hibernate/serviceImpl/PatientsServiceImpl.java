package com.hibernate.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.HospitalMngmtException.InvalidPatientPhoneNoException;
import com.hibernate.entity.Patients;
import com.hibernate.entity.Receptionist;
import com.hibernate.service.PatientsService;

public class PatientsServiceImpl implements PatientsService {
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertPatient(SessionFactory sf)  {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Patients patients = new Patients();
			
			Receptionist receptionist=new Receptionist();
			
			System.out.println("Enter Patient details:\\nPatient Id:");
			patients.setPatientID(sc.nextInt());
			System.out.println("Enter Patient name:");
			patients.setName(sc.next());
			System.out.println("Enter Patient Age:");
			int age = sc.nextInt();
			patients.setAge(age);
			System.out.println("Enter Patient gender:(Male/Female)");
			patients.setGender(sc.next());
			System.out.println("Enter Patient diagnosis:");
			patients.setDiagnosis(sc.next());
			System.out.println("Enter Patient Phone number:\n91+:");
			long phoneNo = sc.nextLong();
			
			// Check for valid phone number format (just an example, adjust as needed)
	        if (String.valueOf(phoneNo).length() != 10) {
	            throw new InvalidPatientPhoneNoException("Phone number must be 10 digits.");
	        }
	        
			
			patients.setPhoneNo(phoneNo);
			System.out.println("Enter Patient Address:");
			patients.setAddress(sc.next());
			
			System.out.println("Enter Receptionist Id:");
			receptionist.setReceptionistID(sc.nextInt());
			
			session.persist(patients);
            transaction.commit();
			
			System.out.println("Patient inserted successfully!");
			
			
		}catch (InvalidPatientPhoneNoException e) {
	        System.out.println("Error: " + e.getMessage());
	        // Handle or log the exception as needed
	    }
		
		
		catch (Exception e) {
			 if (transaction != null) transaction.rollback();
	            System.out.println("Error inserting patient: " + e.getMessage());
		}
		finally {
            session.close();
        }
}

public void updatePatient(SessionFactory sf) {
	 session = sf.openSession();
     Transaction transaction = session.beginTransaction();
     try {
         System.out.println("Enter Patient Id to update:");
         int patientId = sc.nextInt();
         Patients patient = session.get(Patients.class, patientId);
         if (patient != null) {
             System.out.println("Updating Patient details. \nCurrent details: " + patient);
             System.out.println("Enter new Patient name (or leave blank to keep current):");
             String newName = sc.next();
             if (!newName.isEmpty()) patient.setName(newName);
             
             System.out.println("Enter new Patient Age (or enter -1 to keep current):");
             int newAge = sc.nextInt();
             if (newAge != -1) patient.setAge(newAge);
             
             System.out.println("Enter new Patient gender (or leave blank to keep current):");
             String newGender = sc.next();
             if (!newGender.isEmpty()) patient.setGender(newGender);
             
             System.out.println("Enter new Patient diagnosis (or leave blank to keep current):");
             String newDiagnosis = sc.next();
             if (!newDiagnosis.isEmpty()) patient.setDiagnosis(newDiagnosis);
             
             System.out.println("Enter new Patient Phone number (or enter -1 to keep current):");
             long newPhoneNo = sc.nextLong();
             if (newPhoneNo != -1) patient.setPhoneNo(newPhoneNo);
             
             System.out.println("Enter new Patient Address (or leave blank to keep current):");
             String newAddress = sc.next();
             if (!newAddress.isEmpty()) patient.setAddress(newAddress);

             session.update(patient);
             transaction.commit();
             System.out.println("Patient updated successfully!");
         } else {
             System.out.println("Patient not found with ID: " + patientId);
         }
     } catch (Exception e) {
         if (transaction != null) transaction.rollback();
         System.out.println("Error updating patient: " + e.getMessage());
     } finally {
         session.close();
     }

}

public void deletePatient(SessionFactory sf) {
	session = sf.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        System.out.println("Enter Patient Id to delete:");
        int patientId = sc.nextInt();
        Patients patient = session.get(Patients.class, patientId);
        if (patient != null) {
            session.delete(patient);
            transaction.commit();
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Patient not found with ID: " + patientId);
        }
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        System.out.println("Error deleting patient: " + e.getMessage());
    } finally {
        session.close();
    }

}

public void getAllPatient(SessionFactory sf) {
	session = sf.openSession();
	 try {
         Query<Patients> query = session.createQuery("from Patients", Patients.class);
         List<Patients> patientsList = query.list();
         System.out.println("All Patients:");
         for (Patients patient : patientsList) {
             System.out.println(patient);
         }
     } catch (Exception e) {
         System.out.println("Error retrieving patients: " + e.getMessage());
     } finally {
         session.close();
     }

}

public void getPatient(SessionFactory sf) {
	 session = sf.openSession();
	 try {
         System.out.println("Enter Patient Id to retrieve:");
         int patientId = sc.nextInt();
         Patients patient = session.get(Patients.class, patientId);
         if (patient != null) {
             System.out.println("Patient details: " + patient);
         } else {
             System.out.println("Patient not found with ID: " + patientId);
         }
     } catch (Exception e) {
         System.out.println("Error retrieving patient: " + e.getMessage());
     } finally {
         session.close();
     }
  }

}
