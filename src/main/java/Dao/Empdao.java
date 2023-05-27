package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Empdetails;

public class Empdao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Empdetails emp) {
		entityTransaction.begin();
		entityManager.persist(emp);
		entityTransaction.commit();
	}

	public Empdetails fetch(String name) {

		List<Empdetails> list = entityManager.createQuery("select x from Empdetails x where name=?1")
				.setParameter(1, name).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Empdetails fetch(int id) {
		List<Empdetails> list = entityManager.createQuery("select x from Empdetails x where id=?1").setParameter(1, id)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<Empdetails> fetch() {
		List<Empdetails> list = entityManager.createQuery("select x from Empdetails x ").getResultList();
		return list;
	}

	public void update(Empdetails emp) {
		entityTransaction.begin();
		entityManager.merge(emp);
		entityTransaction.commit();
	}

	public void delete(int id) {
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Empdetails.class, id));
		entityTransaction.commit();

	}
}
