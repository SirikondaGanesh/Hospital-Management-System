package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface HsptlRoomService {

	void insertHsptlRoom(SessionFactory sf) throws Exception ;  // Specify the type of exception to throw
	void updateHsptlRoom(SessionFactory sf);

	void deleteHsptlRoom(SessionFactory sf);

	void getAllHsptlRoom(SessionFactory sf);
	void getHsptlRoom(SessionFactory sf);
}
