package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface TreatmentsService {
	void insertTreatment(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updateTreatment(SessionFactory sf);

	void deleteTreatment(SessionFactory sf);

	void getAllTreatment(SessionFactory sf);
	void getTreatment(SessionFactory sf);

}
