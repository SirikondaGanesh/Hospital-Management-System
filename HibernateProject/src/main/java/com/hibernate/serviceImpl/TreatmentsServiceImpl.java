package com.hibernate.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.HospitalMngmtException.InvalidTreatmentCostException;
import com.hibernate.entity.Treatments;
import com.hibernate.service.TreatmentsService;

public class TreatmentsServiceImpl implements TreatmentsService{
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertTreatment(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Treatments treatments=new Treatments();
			
			System.out.println("Enter Treatment Details: \nEnter Treatment ID:");
            treatments.setTreatmentID(sc.nextInt());
            sc.nextLine(); // Consume newline

            System.out.println("Enter Treatment Date (YYYY-MM-DD):");
            treatments.setTreatmentDate(LocalDate.parse(sc.nextLine()));

            System.out.println("Enter Treatment Name:");
            treatments.setTreatmentName(sc.nextLine());

            System.out.println("Is Follow-Up Required? (true/false):");
            treatments.setFollowUpRequired(sc.nextBoolean());
            
            

            System.out.println("Enter Treatment Cost:");
            int treatmentCost = sc.nextInt();
            try {
                // Step 1: Validate that the treatment cost is a positive value
                if (treatmentCost <= 0) {
                    // If cost is invalid (0 or negative), throw the custom exception
                    throw new InvalidTreatmentCostException("Invalid treatment cost! Treatment cost must be a positive number.");
                }

                // Step 2: Set the treatment cost if it's valid
                treatments.setTreatmentCost(treatmentCost);
                System.out.println("Treatment cost set to: " + treatmentCost);

            } catch (InvalidTreatmentCostException e) {
                // Catch and handle the exception
                System.out.println(e.getMessage());  // Print the custom exception message
            }
            
            

            session.persist(treatments);
            transaction.commit();
            System.out.println("Treatment inserted successfully!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error inserting treatment: " + e.getMessage());
        } finally {
            session.close();
        }
		
	}
public void updateTreatment(SessionFactory sf) {
		
	 Session session = sf.openSession();
     Transaction transaction = session.beginTransaction();
     try {
         System.out.println("Enter Treatment ID to update:");
         int treatmentId = sc.nextInt();
         Treatments treatment = session.get(Treatments.class, treatmentId);
         if (treatment != null) {
             System.out.println("Current details: " + treatment);

             System.out.println("Enter new Treatment Date (or leave blank to keep current):");
             sc.nextLine(); // Consume newline
             String newDateInput = sc.nextLine();
             if (!newDateInput.isEmpty()) {
                 treatment.setTreatmentDate(LocalDate.parse(newDateInput));
             }

             System.out.println("Enter new Treatment Name (or leave blank to keep current):");
             String newName = sc.nextLine();
             if (!newName.isEmpty()) {
                 treatment.setTreatmentName(newName);
             }

             System.out.println("Is Follow-Up Required? (true/false) (or leave blank to keep current):");
             if (sc.hasNextBoolean()) {
                 treatment.setFollowUpRequired(sc.nextBoolean());
             }

             System.out.println("Enter new Treatment Cost (or enter -1 to keep current):");
             int newCost = sc.nextInt();
             if (newCost != -1) {
                 treatment.setTreatmentCost(newCost);
             }

             session.update(treatment);
             transaction.commit();
             System.out.println("Treatment updated successfully!");
         } else {
             System.out.println("Treatment not found with ID: " + treatmentId);
         }
     } catch (Exception e) {
         if (transaction != null) transaction.rollback();
         System.out.println("Error updating treatment: " + e.getMessage());
     } finally {
         session.close();
     }
	}

public void deleteTreatment(SessionFactory sf) {
		
	Session session = sf.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        System.out.println("Enter Treatment ID to delete:");
        int treatmentId = sc.nextInt();
        Treatments treatment = session.get(Treatments.class, treatmentId);
        if (treatment != null) {
            session.delete(treatment);
            transaction.commit();
            System.out.println("Treatment deleted successfully!");
        } else {
            System.out.println("Treatment not found with ID: " + treatmentId);
        }
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        System.out.println("Error deleting treatment: " + e.getMessage());
    } finally {
        session.close();
    }
	}

public void getAllTreatment(SessionFactory sf) {
	Session session = sf.openSession();
    try {
        Query<Treatments> query = session.createQuery("from Treatments", Treatments.class);
        List<Treatments> treatmentList = query.list();
        System.out.println("All Treatments:");
        for (Treatments treatment : treatmentList) {
            System.out.println(treatment);
        }
    } catch (Exception e) {
        System.out.println("Error retrieving treatments: " + e.getMessage());
    } finally {
        session.close();
    }
	}
	public void getTreatment(SessionFactory sf) {
		 Session session = sf.openSession();
	        try {
	            System.out.println("Enter Treatment ID to retrieve:");
	            int treatmentId = sc.nextInt();
	            Treatments treatment = session.get(Treatments.class, treatmentId);
	            if (treatment != null) {
	                System.out.println("Treatment details: " + treatment);
	            } else {
	                System.out.println("Treatment not found with ID: " + treatmentId);
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving treatment: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	}

}
