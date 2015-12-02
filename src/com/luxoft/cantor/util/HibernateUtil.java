package com.luxoft.cantor.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    public static void sendToDataBase(Object object) {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
    }
}
