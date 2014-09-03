package com.marakana.contacts.repositories;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;


public class Repository<E> {
	private final Class<E> entityClass;

	private final EntityManager em = Persistence.createEntityManagerFactory(
			"training").createEntityManager();

	public Repository(Class<E> entityClass){
		this.entityClass=entityClass;
	}
		
	public E find(long id) {
		return em.find(entityClass, id);
	}

	public E save(E entity) {
		em.getTransaction().begin();
		entity=em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	public void delete(E entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
	public List<E> findAll(){
		return em.createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();
	}

}
