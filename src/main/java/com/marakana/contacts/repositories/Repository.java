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

	public void save(E entity) {
		em.merge(entity);
	}

	public void delete(E entity) {
		em.remove(entity);
	}
	public List<E> findAll(){
		return em.createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();
	}

}
