package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface PatientsService {
	void insertPatient(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updatePatient(SessionFactory sf);

	void deletePatient(SessionFactory sf);

	void getAllPatient(SessionFactory sf);
	void getPatient(SessionFactory sf);


}
