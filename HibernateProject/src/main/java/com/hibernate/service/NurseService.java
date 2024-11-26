package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface NurseService {

	void insertNurse(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updateNurse(SessionFactory sf);

	void deleteNurse(SessionFactory sf);

	void getAllNurse(SessionFactory sf);
	void getNurse(SessionFactory sf);
}
