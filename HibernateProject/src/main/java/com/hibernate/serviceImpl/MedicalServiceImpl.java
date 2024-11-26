package com.hibernate.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Medical;
import com.hibernate.service.MedicalService;


public class MedicalServiceImpl implements MedicalService{

	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertMedical(SessionFactory sf) {
		session = sf.openSession();
        Transaction transaction = null;
		 try {
	            transaction = session.beginTransaction();
	            Medical medical = new Medical();

	            // Collecting input for the medical record
	            System.out.print("Enter Medical Details: \nEnter Medication ID: ");
	            medical.setMedicationID(sc.nextInt());

	            System.out.print("Enter Name: ");
	            medical.setName(sc.next());

	            System.out.print("Enter Dosage: ");
	            medical.setDosage(sc.nextInt());

	            System.out.print("Enter Manufacturing Date (yyyy-mm-dd): ");
	            medical.setMFD(LocalDate.parse(sc.next()));

	            System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
	            medical.setEXD(LocalDate.parse(sc.next()));

	            System.out.print("Enter Price: ");
	            medical.setPrice(sc.nextInt());

	            // Saving the medical record
	            session.save(medical);
	            transaction.commit();
	            System.out.println("Medical record inserted successfully.");
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}
	public void updateMedical(SessionFactory sf) {
		session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.print("Enter Medication ID to update: ");
            Integer medicationID = sc.nextInt();
            Medical medical = session.get(Medical.class, medicationID);

            if (medical != null) {
                System.out.print("Enter new Name (current: " + medical.getName() + "): ");
                medical.setName(sc.next());

                System.out.print("Enter new Dosage (current: " + medical.getDosage() + "): ");
                medical.setDosage(sc.nextInt());

                System.out.print("Enter new Manufacturing Date (current: " + medical.getMFD() + "): ");
                medical.setMFD(LocalDate.parse(sc.next()));

                System.out.print("Enter new Expiry Date (current: " + medical.getEXD() + "): ");
                medical.setEXD(LocalDate.parse(sc.next()));

                System.out.print("Enter new Price (current: " + medical.getPrice() + "): ");
                medical.setPrice(sc.nextInt());

                session.update(medical);
                transaction.commit();
                System.out.println("Medical record updated successfully.");
            } else {
                System.out.println("Medical record not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	public void deleteMedical(SessionFactory sf) {
        session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.print("Enter Medication ID to delete: ");
            Integer medicationID = sc.nextInt();
            Medical medical = session.get(Medical.class, medicationID);

            if (medical != null) {
                session.delete(medical);
                transaction.commit();
                System.out.println("Medical record deleted successfully.");
            } else {
                System.out.println("Medical record not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

	}

	public void getAllMedical(SessionFactory sf) {
		 session = sf.openSession();
	        try {
	            Query<Medical> query = session.createQuery("FROM Medical", Medical.class);
	            List<Medical> medicalList = query.list();
	            for (Medical medical : medicalList) {
	                System.out.println(medical);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}
	public void getMedical(SessionFactory sf) {
		 session = sf.openSession();
	        try {
	            System.out.print("Enter Medication ID to retrieve: ");
	            Integer medicationID = sc.nextInt();
	            Medical medical = session.get(Medical.class, medicationID);

	            if (medical != null) {
	                System.out.println(medical);
	            } else {
	                System.out.println("Medical record not found.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}
}
