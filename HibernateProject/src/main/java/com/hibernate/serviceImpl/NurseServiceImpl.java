package com.hibernate.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Nurse;
import com.hibernate.service.NurseService;

public class NurseServiceImpl implements NurseService{

	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertNurse(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Nurse nurse = new Nurse();

            System.out.println("Enter Nurse details:\nEnter Nurse ID:");
            nurse.setNurseID(sc.nextInt());
            sc.nextLine(); // Consume newline

            System.out.println("Enter Nurse Name:");
            nurse.setName(sc.nextLine());

            System.out.println("Enter Nurse Phone Number:");
            nurse.setPhoneNo(sc.nextLong());
            sc.nextLine(); // Consume newline

            System.out.println("Enter Nurse Salary:");
            nurse.setSalary(sc.nextInt());

            session.persist(nurse);
            transaction.commit();
            System.out.println("Nurse inserted successfully!");

		}
		catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error inserting nurse: " + e.getMessage());
        } finally {
            session.close();
        }
		
	}
	public void updateNurse(SessionFactory sf) {
		 Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        try {
	            System.out.println("Enter Nurse ID to update:");
	            int nurseId = sc.nextInt();
	            Nurse nurse = session.get(Nurse.class, nurseId);
	            if (nurse != null) {
	                System.out.println("Current details: " + nurse);

	                System.out.println("Enter new Name (or leave blank to keep current):");
	                sc.nextLine(); // Consume newline
	                String newName = sc.nextLine();
	                if (!newName.isEmpty()) {
	                    nurse.setName(newName);
	                }

	                System.out.println("Enter new Phone Number (or enter -1 to keep current):");
	                long newPhoneNo = sc.nextLong();
	                if (newPhoneNo != -1) {
	                    nurse.setPhoneNo(newPhoneNo);
	                }

	                System.out.println("Enter new Salary (or enter -1 to keep current):");
	                int newSalary = sc.nextInt();
	                if (newSalary != -1) {
	                    nurse.setSalary(newSalary);
	                }

	                session.update(nurse);
	                transaction.commit();
	                System.out.println("Nurse updated successfully!");
	            } else {
	                System.out.println("Nurse not found with ID: " + nurseId);
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            System.out.println("Error updating nurse: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	}
	public void deleteNurse(SessionFactory sf) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            System.out.println("Enter Nurse ID to delete:");
            int nurseId = sc.nextInt();
            Nurse nurse = session.get(Nurse.class, nurseId);
            if (nurse != null) {
                session.delete(nurse);
                transaction.commit();
                System.out.println("Nurse deleted successfully!");
            } else {
                System.out.println("Nurse not found with ID: " + nurseId);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error deleting nurse: " + e.getMessage());
        } finally {
            session.close();
        }
	}
	public void getAllNurse(SessionFactory sf) {
		 Session session = sf.openSession();
	        try {
	            Query<Nurse> query = session.createQuery("from Nurse", Nurse.class);
	            List<Nurse> nurseList = query.list();
	            System.out.println("All Nurses:");
	            for (Nurse nurse : nurseList) {
	                System.out.println(nurse);
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving nurses: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	}
	public void getNurse(SessionFactory sf) {
		Session session = sf.openSession();
        try {
            System.out.println("Enter Nurse ID to retrieve:");
            int nurseId = sc.nextInt();
            Nurse nurse = session.get(Nurse.class, nurseId);
            if (nurse != null) {
                System.out.println("Nurse details: " + nurse);
            } else {
                System.out.println("Nurse not found with ID: " + nurseId);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving nurse: " + e.getMessage());
        } finally {
            session.close();
        }
	}
}
