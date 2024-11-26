package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface BillingService {

	void insertBilling(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updateBilling(SessionFactory sf);

	void deleteBilling(SessionFactory sf);

	void getAllBilling(SessionFactory sf);
	void getBilling(SessionFactory sf);
}
