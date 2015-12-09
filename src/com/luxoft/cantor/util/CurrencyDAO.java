package com.luxoft.cantor.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.luxoft.cantor.repository.Dibs;

public class CurrencyDAO {
	private EntityManager em;
	private EntityTransaction transaction;
	
	private void protectionAgainstOcurrenceExceptionWhenDataAreAddToDB(Dibs dibs) {		
		try {
			transaction.begin();
			em.persist(dibs);
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}
	
	public void persist(String code,
						String name,
						String salary) {
		em = HibernateUtil.getEntityManager();
		transaction = em.getTransaction();
		Dibs dibs = new Dibs.BuildDibs()
							.addCode(code)
							.addName(name)
							.addRate(salary)
							.build();
		
		protectionAgainstOcurrenceExceptionWhenDataAreAddToDB(dibs);
	}

	public void insert(Dibs dibs) {
		em = HibernateUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(dibs);
		em.getTransaction().commit();
	}

	public void update(Dibs dibs) {
		em = HibernateUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.merge(dibs);
		em.getTransaction().commit();
	}

	public void deleteById(String code) {
		Dibs dibs = findById(code);
		em = HibernateUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.remove(dibs);
		em.getTransaction().commit();
	}

	public List<Dibs> findAll() {
		em = HibernateUtil.getEntityManager();
		List<Dibs> list = new ArrayList<Dibs>();

		try {
			list = (List<Dibs>) em.createQuery("from Dibs", Dibs.class)
								  .getResultList();
		} catch (Exception e) {
			System.out.println("There was some problem with SQL query: " + e);
		}

		return list;
	}

	public Dibs findById(String code) {
		em = HibernateUtil.getEntityManager();
		Query query = em.createQuery("FROM Dibs WHERE dibsCode = :dCode");
		
		query.setParameter("dCode", code);
		
		@SuppressWarnings("unchecked")
		List<Dibs> list = (List<Dibs>) query.getResultList();
		
		return list.get(0);
	}
}
