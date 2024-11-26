package com.hibernate.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Billing;
import com.hibernate.service.BillingService;

public class BillingServiceImpl implements BillingService{

	Session session;
	Scanner sc = new Scanner(System.in);
	
    // Method to insert a new billing record
	public void insertBilling(SessionFactory sf) {
		session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Billing billing = new Billing();

            // Collecting input for the billing record
            System.out.print("Enter Billing Details: \nEnter Billing ID: ");
            billing.setBillingID(sc.nextInt());

            System.out.print("Enter Billing Date (yyyy-mm-dd): ");
            billing.setBillingDate(LocalDate.parse(sc.next()));

            System.out.print("Enter Payment Method:\n[PhonePay/Google Pay/Net Banking]: ");
            billing.setPaymentMethod(sc.next());

            System.out.print("Enter Total Amount: ");
            billing.setTotalAmount(sc.nextInt());

            System.out.print("Enter Payment Status:\n[Completed/Not Competed]: ");
            billing.setPaymentStatus(sc.next());

            System.out.print("Enter Phone Number: ");
            billing.setPhoneNo(sc.nextLong());

            // Saving the billing record
            session.save(billing);
            transaction.commit();
            System.out.println("Billing record inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}
    // Method to update an existing billing record
	public void updateBilling(SessionFactory sf) {
		 session = sf.openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            System.out.print("Enter Billing ID to update: ");
	            Integer billingID = sc.nextInt();
	            Billing billing = session.get(Billing.class, billingID);

	            if (billing != null) {
	                System.out.print("Enter new Billing Date (current: " + billing.getBillingDate() + "): ");
	                billing.setBillingDate(LocalDate.parse(sc.next()));

	                System.out.print("Enter new Payment Method (current: " + billing.getPaymentMethod() + "): ");
	                billing.setPaymentMethod(sc.next());

	                System.out.print("Enter new Total Amount (current: " + billing.getTotalAmount() + "): ");
	                billing.setTotalAmount(sc.nextInt());

	                System.out.print("Enter new Payment Status (current: " + billing.getPaymentStatus() + "): ");
	                billing.setPaymentStatus(sc.next());

	                System.out.print("Enter new Phone Number (current: " + billing.getPhoneNo() + "): ");
	                billing.setPhoneNo(sc.nextLong());

	                session.update(billing);
	                transaction.commit();
	                System.out.println("Billing record updated successfully.");
	            } else {
	                System.out.println("Billing record not found.");
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}

    // Method to delete a billing record
	public void deleteBilling(SessionFactory sf) {
		session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.print("Enter Billing ID to delete: ");
            Integer billingID = sc.nextInt();
            Billing billing = session.get(Billing.class, billingID);

            if (billing != null) {
                session.delete(billing);
                transaction.commit();
                System.out.println("Billing record deleted successfully.");
            } else {
                System.out.println("Billing record not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
	}

	public void getAllBilling(SessionFactory sf) {
		 session = sf.openSession();
	        try {
	            Query<Billing> query = session.createQuery("FROM Billing", Billing.class);
	            List<Billing> billingList = query.list();
	            for (Billing billing : billingList) {
	                System.out.println(billing);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}
    // Method to get a specific billing record by ID
	public void getBilling(SessionFactory sf) {
		session = sf.openSession();
        try {
            System.out.print("Enter Billing ID to retrieve: ");
            Integer billingID = sc.nextInt();
            Billing billing = session.get(Billing.class, billingID);

            if (billing != null) {
                System.out.println(billing);
            } else {
                System.out.println("Billing record not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
	}
}
