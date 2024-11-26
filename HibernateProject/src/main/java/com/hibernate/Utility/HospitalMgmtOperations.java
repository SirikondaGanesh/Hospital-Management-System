package com.hibernate.Utility;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.serviceImpl.BillingServiceImpl;
import com.hibernate.serviceImpl.DoctorServiceImpl;
import com.hibernate.serviceImpl.HsptlRoomServiceImpl;
import com.hibernate.serviceImpl.MedicalServiceImpl;
import com.hibernate.serviceImpl.NurseServiceImpl;
import com.hibernate.serviceImpl.PatientsServiceImpl;
import com.hibernate.serviceImpl.ReceptionistServiceImpl;
import com.hibernate.serviceImpl.TreatmentsServiceImpl;

public class HospitalMgmtOperations {
	

    public static void main(String[] args) {
        // Create a SessionFactory
        SessionFactory sessionFactory = ConfigUtility.getsFactory();
        Scanner scanner = new Scanner(System.in);

        // Initialize service implementations
        PatientsServiceImpl patientsService = new PatientsServiceImpl();
        ReceptionistServiceImpl receptionistService = new ReceptionistServiceImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        HsptlRoomServiceImpl hospitalRoomService = new HsptlRoomServiceImpl();
        NurseServiceImpl nurseService = new NurseServiceImpl();
        TreatmentsServiceImpl treatmentService = new TreatmentsServiceImpl();
        MedicalServiceImpl medicalService = new MedicalServiceImpl();
        BillingServiceImpl billingService = new BillingServiceImpl();

        // Main menu loop
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Receptionists");
            System.out.println("3. Manage Doctors");
            System.out.println("4. Manage Hospital Rooms");
            System.out.println("5. Manage Nurses");
            System.out.println("6. Manage Treatments");
            System.out.println("7. Manage Medical");
            System.out.println("8. Manage Billing");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managePatients(scanner, patientsService, sessionFactory);
                    break;
                case 2:
                    manageReceptionists(scanner, receptionistService, sessionFactory);
                    break;
                case 3:
                    manageDoctors(scanner, doctorService, sessionFactory);
                    break;
                case 4:
                    manageHospitalRooms(scanner, hospitalRoomService, sessionFactory);
                    break;
                case 5:
                    manageNurses(scanner, nurseService, sessionFactory);
                    break;
                case 6:
                    manageTreatments(scanner, treatmentService, sessionFactory);
                    break;
                case 7:
                    manageMedical(scanner, medicalService, sessionFactory);
                    break;
                case 8:
                    manageBilling(scanner, billingService, sessionFactory);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    sessionFactory.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void managePatients(Scanner scanner, PatientsServiceImpl patientsService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Patients ---");
            System.out.println("1. Insert Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Get Patient by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    patientsService.insertPatient(sessionFactory);
                    break;
                case 2:
                    patientsService.updatePatient(sessionFactory);
                    break;
                case 3:
                    patientsService.deletePatient(sessionFactory);
                    break;
                case 4:
                    patientsService.getAllPatient(sessionFactory);
                    break;
                case 5:
                    patientsService.getPatient(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void manageReceptionists(Scanner scanner, ReceptionistServiceImpl receptionistService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Receptionists ---");
            System.out.println("1. Insert Receptionist");
            System.out.println("2. Update Receptionist");
            System.out.println("3. Delete Receptionist");
            System.out.println("4. View All Receptionists");
            System.out.println("5. Get Receptionist by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    receptionistService.insertReceptionist(sessionFactory);
                    break;
                case 2:
                    receptionistService.updateReceptionist(sessionFactory);
                    break;
                case 3:
                    receptionistService.deleteReceptionist(sessionFactory);
                    break;
                case 4:
                    receptionistService.getAllReceptionist(sessionFactory);
                    break;
                case 5:
                    receptionistService.getReceptionist(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void manageDoctors(Scanner scanner, DoctorServiceImpl doctorService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Doctors ---");
            System.out.println("1. Insert Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. View All Doctors");
            System.out.println("5. Get Doctor by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    doctorService.insertDoctor(sessionFactory);
                    break;
                case 2:
                    doctorService.updateDoctor(sessionFactory);
                    break;
                case 3:
                    doctorService.deleteDoctor(sessionFactory);
                    break;
                case 4:
                    doctorService.getAllDoctor(sessionFactory);
                    break;
                case 5:
                    doctorService.getDoctor(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void manageHospitalRooms(Scanner scanner, HsptlRoomServiceImpl hospitalRoomService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Hospital Rooms ---");
            System.out.println("1. Insert Hospital Room");
            System.out.println("2. Update Hospital Room");
            System.out.println("3. Delete Hospital Room");
            System.out.println("4. View All Hospital Rooms");
            System.out.println("5. Get Hospital Room by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    hospitalRoomService.insertHsptlRoom(sessionFactory);
                    break;
                case 2:
                    hospitalRoomService.updateHsptlRoom(sessionFactory);
                    break;
                case 3:
                    hospitalRoomService.deleteHsptlRoom(sessionFactory);
                    break;
                case 4:
                    hospitalRoomService.getAllHsptlRoom(sessionFactory);
                    break;
                case 5:
                    hospitalRoomService.getHsptlRoom(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void manageNurses(Scanner scanner, NurseServiceImpl nurseService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Nurses ---");
            System.out.println("1. Insert Nurse");
            System.out.println("2. Update Nurse");
            System.out.println("3. Delete Nurse");
            System.out.println("4. View All Nurses");
            System.out.println("5. Get Nurse by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    nurseService.insertNurse(sessionFactory);
                    break;
                case 2:
                    nurseService.updateNurse(sessionFactory);
                    break;
                case 3:
                    nurseService.deleteNurse(sessionFactory);
                    break;
                case 4:
                    nurseService.getAllNurse(sessionFactory);
                    break;
                case 5:
                    nurseService.getNurse(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void manageTreatments(Scanner scanner, TreatmentsServiceImpl treatmentService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Treatments ---");
            System.out.println("1. Insert Treatment");
            System.out.println("2. Update Treatment");
            System.out.println("3. Delete Treatment");
            System.out.println("4. View All Treatments");
            System.out.println("5. Get Treatment by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	treatmentService.insertTreatment(sessionFactory);
                    break;
                case 2:
                	treatmentService.updateTreatment(sessionFactory);
                    break;
                case 3:
                	treatmentService.deleteTreatment(sessionFactory);
                    break;
                case 4:
                	treatmentService.getAllTreatment(sessionFactory);
                    break;
                case 5:
                	treatmentService.getTreatment(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
    private static void manageMedical(Scanner scanner, MedicalServiceImpl MedicalService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Medical ---");
            System.out.println("1. Insert Medical");
            System.out.println("2. Update Medical");
            System.out.println("3. Delete Medical");
            System.out.println("4. View All Medical");
            System.out.println("5. Get Medical by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	MedicalService.insertMedical(sessionFactory);
                    break;
                case 2:
                	MedicalService.updateMedical(sessionFactory);
                    break;
                case 3:
                	MedicalService.deleteMedical(sessionFactory);
                    break;
                case 4:
                	MedicalService.getAllMedical(sessionFactory);
                    break;
                case 5:
                	MedicalService.getMedical(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
    
    private static void manageBilling(Scanner scanner, BillingServiceImpl BillingService, SessionFactory sessionFactory) {
        while (true) {
            System.out.println("\n--- Manage Billing ---");
            System.out.println("1. Insert Billing");
            System.out.println("2. Update Billing");
            System.out.println("3. Delete Billing");
            System.out.println("4. View All Billing");
            System.out.println("5. Get Billing by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	BillingService.insertBilling(sessionFactory);
                    break;
                case 2:
                	BillingService.updateBilling(sessionFactory);
                    break;
                case 3:
                	BillingService.deleteBilling(sessionFactory);
                    break;
                case 4:
                	BillingService.getAllBilling(sessionFactory);
                    break;
                case 5:
                	BillingService.getBilling(sessionFactory);
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }}

