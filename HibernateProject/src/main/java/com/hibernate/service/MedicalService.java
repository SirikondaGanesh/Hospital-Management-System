package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface MedicalService {

	void insertMedical(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updateMedical(SessionFactory sf);

	void deleteMedical(SessionFactory sf);

	void getAllMedical(SessionFactory sf);
	void getMedical(SessionFactory sf);
}
