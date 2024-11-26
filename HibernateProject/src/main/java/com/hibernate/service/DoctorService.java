package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface DoctorService {
	void insertDoctor(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updateDoctor(SessionFactory sf);

	void deleteDoctor(SessionFactory sf);

	void getAllDoctor(SessionFactory sf);
	void getDoctor(SessionFactory sf);

}
