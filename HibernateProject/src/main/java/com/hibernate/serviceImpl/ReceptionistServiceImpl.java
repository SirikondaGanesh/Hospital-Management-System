package com.hibernate.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.HospitalMngmtException.InvalidShiftScheduleException;
import com.hibernate.entity.Receptionist;
import com.hibernate.service.ReceptionistService;

public class ReceptionistServiceImpl implements ReceptionistService {
	Session session;
	Scanner sc = new Scanner(System.in);
	public void insertReceptionist(SessionFactory sf)  {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Receptionist receptionist = new Receptionist();
			System.out.println("Enter Receptionist details:\\nReceptionist Id:");
			receptionist.setReceptionistID(sc.nextInt());
			System.out.println("Enter Receptionist name:");
			receptionist.setName(sc.next());
			System.out.println("Enter Receptionist Phone number:");
            receptionist.setPhoneNo(sc.nextLong());
			System.out.println("Enter Receptionist hireDate: \n(YYYY-MM-DD):");
            receptionist.setHireDate(java.sql.Date.valueOf(sc.next())); // Assuming hireDate is of type java.sql.Date
			
            
            // Shift Schedule validation
            String shiftSchedule;
            while (true) {
                System.out.println("Enter Receptionist shiftSchedule:\n[ Morning/ Afternoon/ Night]:");
                shiftSchedule = sc.next();

                try {
                    // Step 2: Check the input and throw custom exception if it's invalid
                    if (!(shiftSchedule.equalsIgnoreCase("Morning") || shiftSchedule.equalsIgnoreCase("Afternoon") || shiftSchedule.equalsIgnoreCase("Night"))) {
                        throw new InvalidShiftScheduleException("Invalid shift schedule! Please enter Morning, Afternoon, or Night.");
                    }
                    break; // If valid, exit the loop
                } catch (InvalidShiftScheduleException e) {
                    // Handle the exception
                    System.out.println(e.getMessage());
                }
            }
            // Setting valid shift schedule after validation
            receptionist.setShiftSchedule(shiftSchedule);
            System.out.println("Shift schedule set to: " + shiftSchedule);
            
            
			
			System.out.println("Enter Receptionist Salary:");
            receptionist.setSalary(sc.nextInt());
			
			
			
			session.persist(receptionist);
            transaction.commit();
			
			System.out.println("Receptionist inserted successfully!");
		} 
		catch (Exception e) {
			 if (transaction != null) transaction.rollback();
	            System.out.println("Error inserting receptionist: " + e.getMessage());
		}
		finally {
            session.close();
        }
	}
	public void updateReceptionist(SessionFactory sf){
		 session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        try {
	            System.out.println("Enter Receptionist Id to update:");
	            int receptionistId = sc.nextInt();
	            Receptionist receptionist = session.get(Receptionist.class, receptionistId);
	            if (receptionist != null) {
	                System.out.println("Current details: " + receptionist);
	                
	                System.out.println("Enter new Receptionist name (or leave blank to keep current):");
	                String newName = sc.next();
	                if (!newName.isEmpty()) receptionist.setName(newName);
	                
	                System.out.println("Enter new Receptionist Phone number (or enter -1 to keep current):");
	                long newPhoneNo = sc.nextLong();
	                if (newPhoneNo != -1) receptionist.setPhoneNo(newPhoneNo);
	                
	                System.out.println("Enter new Receptionist hireDate (or leave blank to keep current):");
	                String newHireDate = sc.next();
	                if (!newHireDate.isEmpty()) {
	                    receptionist.setHireDate(java.sql.Date.valueOf(newHireDate));
	                }
	                
	                System.out.println("Enter new Receptionist shiftSchedule (or leave blank to keep current):");
	                String newShiftSchedule = sc.next();
	                if (!newShiftSchedule.isEmpty()) receptionist.setShiftSchedule(newShiftSchedule);
	                
	                System.out.println("Enter new Receptionist Salary (or enter -1 to keep current):");
	                int newSalary = sc.nextInt();
	                if (newSalary != -1) receptionist.setSalary(newSalary);
	                
	                session.update(receptionist);
	                transaction.commit();
	                System.out.println("Receptionist updated successfully!");
	            } else {
	                System.out.println("Receptionist not found with ID: " + receptionistId);
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            System.out.println("Error updating receptionist: " + e.getMessage());
	        } finally {
	            session.close();
	        }
		
	}

	public void deleteReceptionist(SessionFactory sf){
		 session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        try {
	            System.out.println("Enter Receptionist Id to delete:");
	            int receptionistId = sc.nextInt();
	            Receptionist receptionist = session.get(Receptionist.class, receptionistId);
	            if (receptionist != null) {
	                session.delete(receptionist);
	                transaction.commit();
	                System.out.println("Receptionist deleted successfully!");
	            } else {
	                System.out.println("Receptionist not found with ID: " + receptionistId);
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            System.out.println("Error deleting receptionist: " + e.getMessage());
	        } finally {
	            session.close();
	        }
		
	}

	public void getAllReceptionist(SessionFactory sf){
		session = sf.openSession();
        try {
            Query<Receptionist> query = session.createQuery("from Receptionist", Receptionist.class);
            List<Receptionist> receptionistList = query.list();
            System.out.println("All Receptionists:");
            for (Receptionist receptionist : receptionistList) {
                System.out.println(receptionist);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving receptionists: " + e.getMessage());
        } finally {
            session.close();
        }
		
	}

	public void getReceptionist(SessionFactory sf){
		 session = sf.openSession();
	        try {
	            System.out.println("Enter Receptionist Id to retrieve:");
	            int receptionistId = sc.nextInt();
	            Receptionist receptionist = session.get(Receptionist.class, receptionistId);
	            if (receptionist != null) {
	                System.out.println("Receptionist details: " + receptionist);
	            } else {
	                System.out.println("Receptionist not found with ID: " + receptionistId);
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving receptionist: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	    
		
	}
}
