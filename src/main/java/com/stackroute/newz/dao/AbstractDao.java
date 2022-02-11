package com.stackroute.newz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//Dealing with Hibernate and MySQL
public class AbstractDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	protected Session getSession() {
		return sessionfactory.getCurrentSession();
	}
	
	public void save(Object obj) {
		getSession().save(obj);
	}
	
	public void update(Object obj) {
		getSession().update(obj);
	}
	
	public void delete(Object obj) {
		getSession().delete(obj);
	}

}
