package com.hibernate.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.HsptlRoom;
import com.hibernate.service.HsptlRoomService;

public class HsptlRoomServiceImpl implements HsptlRoomService {

	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertHsptlRoom(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
              HsptlRoom room = new HsptlRoom();
            
            // Input for the hospital room details
            System.out.println("Enter HsptlRoom details:\\nEnter Room ID:");
            room.setRoomID(sc.nextInt());
            sc.nextLine(); // Consume newline

            System.out.println("Enter Room Type:");
            room.setRoomType(sc.nextLine());

            System.out.println("Enter Room Capacity:");
            room.setCapacity(sc.nextInt());

            System.out.println("Is the room occupied? (true for Yes, false for No):");
            room.setOccupiedStatus(sc.nextBoolean());

            System.out.println("Enter Room Cost:");
            room.setCost(sc.nextInt());

            // Persist the room object
            session.persist(room);
            transaction.commit();
            System.out.println("Hospital Room inserted successfully!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error inserting hospital room: " + e.getMessage());
        } finally {
            session.close();
        
		}
	}
	public void updateHsptlRoom(SessionFactory sf) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            System.out.println("Enter Room ID to update:");
            int roomId = sc.nextInt();
            HsptlRoom room = session.get(HsptlRoom.class, roomId);
            if (room != null) {
                System.out.println("Current details: " + room);

                System.out.println("Enter new Room Type (or leave blank to keep current):");
                sc.nextLine(); // Consume newline
                String newRoomType = sc.nextLine();
                if (!newRoomType.isEmpty()) {
                    room.setRoomType(newRoomType);
                }

                System.out.println("Enter new Room Capacity (or enter -1 to keep current):");
                int newCapacity = sc.nextInt();
                if (newCapacity != -1) {
                    room.setCapacity(newCapacity);
                }

                System.out.println("Is the room occupied? (true for Yes, false for No or enter -1 to keep current):");
                boolean newOccupiedStatus = sc.nextBoolean();
                room.setOccupiedStatus(newOccupiedStatus); // Update directly, or modify logic as needed

                System.out.println("Enter new Room Cost (or enter -1 to keep current):");
                int newCost = sc.nextInt();
                if (newCost != -1) {
                    room.setCost(newCost);
                }

                // Update the room object
                session.update(room);
                transaction.commit();
                System.out.println("Hospital Room updated successfully!");
            } else {
                System.out.println("Hospital Room not found with ID: " + roomId);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error updating hospital room: " + e.getMessage());
        } finally {
            session.close();
        }
	}

	public void deleteHsptlRoom(SessionFactory sf) {
		 Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        try {
	            System.out.println("Enter Room ID to delete:");
	            int roomId = sc.nextInt();
	            HsptlRoom room = session.get(HsptlRoom.class, roomId);
	            if (room != null) {
	                session.delete(room);
	                transaction.commit();
	                System.out.println("Hospital Room deleted successfully!");
	            } else {
	                System.out.println("Hospital Room not found with ID: " + roomId);
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            System.out.println("Error deleting hospital room: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	}

	public void getAllHsptlRoom(SessionFactory sf) {
		 Session session = sf.openSession();
	        try {
	            Query<HsptlRoom> query = session.createQuery("from HsptlRoom", HsptlRoom.class);
	            List<HsptlRoom> roomList = query.list();
	            System.out.println("All Hospital Rooms:");
	            for (HsptlRoom room : roomList) {
	                System.out.println(room);
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving hospital rooms: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	}
	public void getHsptlRoom(SessionFactory sf) {
		 Session session = sf.openSession();
	        try {
	            System.out.println("Enter Room ID to retrieve:");
	            int roomId = sc.nextInt();
	            HsptlRoom room = session.get(HsptlRoom.class, roomId);
	            if (room != null) {
	                System.out.println("Hospital Room details: " + room);
	            } else {
	                System.out.println("Hospital Room not found with ID: " + roomId);
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving hospital room: " + e.getMessage());
	        } finally {
	            session.close();
	        }
	}
}
