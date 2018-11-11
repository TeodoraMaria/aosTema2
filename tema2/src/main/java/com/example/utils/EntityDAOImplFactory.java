package com.example.utils;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dao.PersonDAO;
import com.example.dao.PersonImpl;



public class EntityDAOImplFactory {

	public static final String PERSISTANCE_UNIT = "persistenceUnit";
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT);

	public static PersonDAO createNewPersonDAOImpl(String persistenceUnitName) {
		return new PersonImpl(persistenceUnitName);
	}
}