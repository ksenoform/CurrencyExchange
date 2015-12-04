package com.luxoft.cantor.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	private static EntityManagerFactory createEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("myBase");
			} catch (ExceptionInInitializerError e) {
				throw e;
			}
		}
		
		return entityManagerFactory;
	}

	private static EntityManager createEntityManager() {
		if (entityManager == null) {
			try {
				entityManager = createEntityManagerFactory().createEntityManager();
			} catch (ExceptionInInitializerError e) {
				throw e;
			}
		}

		return entityManager;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return createEntityManagerFactory();
	}

	public static EntityManager getEntityManager() {
		return createEntityManager();
	}

	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
