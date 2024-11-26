package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface ReceptionistService {
	void insertReceptionist(SessionFactory sf)  throws Exception;

	void updateReceptionist(SessionFactory sf);

	void deleteReceptionist(SessionFactory sf);

	void getAllReceptionist(SessionFactory sf);

	void getReceptionist(SessionFactory sf);


}
