package com.hibernate.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.HospitalMngmtException.InvalidDoctorPhoneNoException;
import com.HospitalMngmtException.InvalidPatientPhoneNoException;
import com.hibernate.entity.Doctor;
import com.hibernate.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
	Session session;
	Scanner sc = new Scanner(System.in);

    // Method to insert a new doctor record
	public void insertDoctor(SessionFactory sf) {
		session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Doctor doctor = new Doctor();

            // Collecting input for the doctor record
            System.out.print("Enter Doctor details:\nEnter Doctor ID: ");
            doctor.setDoctorID(sc.nextInt());  // assuming Doctor entity has setDoctorID method

            System.out.print("Enter Name: ");
            doctor.setName(sc.next()); // assuming Doctor entity has setName method

            System.out.print("Enter Specialty: ");
            doctor.setSpecialty(sc.next()); // assuming Doctor entity has setSpecialty method

            // Example for validating doctor phone number
            System.out.print("Enter Doctor Phone Number: ");
			long phoneNo = sc.nextLong();
            if (String.valueOf(phoneNo).length() != 10) {
	            throw new InvalidDoctorPhoneNoException("Phone number must be 10 digits.");
	        }
            
            
            
            System.out.print("Enter Availability Schedule: \n[ Morning/ Afternoon/ Night]:");
            doctor.setAvailabilitySchedule(sc.next()); // assuming Doctor entity has setAvailabilitySchedule method

            // Saving the doctor record
            session.save(doctor);
            transaction.commit();
            System.out.println("Doctor record inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
		}
	
    // Method to update an existing doctor record
	public void updateDoctor(SessionFactory sf) {
		
		session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.print("Enter Doctor ID to update: ");
            Integer doctorID = sc.nextInt();
            Doctor doctor = session.get(Doctor.class, doctorID);

            if (doctor != null) {
                System.out.print("Enter new Name (current: " + doctor.getName() + "): ");
                doctor.setName(sc.next());

                System.out.print("Enter new Specialty (current: " + doctor.getSpecialty() + "): ");
                doctor.setSpecialty(sc.next());

                System.out.print("Enter new Phone Number (current: " + doctor.getPhoneNo() + "): ");
                doctor.setPhoneNo(sc.nextLong());

                System.out.print("Enter new Availability Schedule (current: " + doctor.getAvailabilitySchedule() + "): ");
                doctor.setAvailabilitySchedule(sc.next());

                session.update(doctor);
                transaction.commit();
                System.out.println("Doctor record updated successfully.");
            } else {
                System.out.println("Doctor record not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}
    // Method to delete a doctor record
	public void deleteDoctor(SessionFactory sf) {
		session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.print("Enter Doctor ID to delete: ");
            Integer doctorID = sc.nextInt();
            Doctor doctor = session.get(Doctor.class, doctorID);

            if (doctor != null) {
                session.delete(doctor);
                transaction.commit();
                System.out.println("Doctor record deleted successfully.");
            } else {
                System.out.println("Doctor record not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
	}

    // Method to get all doctor records
	public void getAllDoctor(SessionFactory sf) {
		session = sf.openSession();
        try {
            Query<Doctor> query = session.createQuery("FROM Doctor", Doctor.class);
            List<Doctor> doctorList = query.list();
            for (Doctor doctor : doctorList) {
                System.out.println(doctor); // assuming Doctor class has a meaningful toString() method
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
	}
    // Method to get a specific doctor record by ID
	public void getDoctor(SessionFactory sf) {
		session = sf.openSession();
        try {
            System.out.print("Enter Doctor ID to retrieve: ");
            Integer doctorID = sc.nextInt();
            Doctor doctor = session.get(Doctor.class, doctorID);

            if (doctor != null) {
                System.out.println(doctor); // assuming Doctor class has a meaningful toString() method
            } else {
                System.out.println("Doctor record not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

	    }
	}

