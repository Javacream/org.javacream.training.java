package org.javacream.training.java.profile.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.javacream.training.java.profile.api.Profile;
import org.javacream.training.java.profile.api.ProfileService;

public class JpaProfileService implements ProfileService{
	private EntityManager entityManager;

	public JpaProfileService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.javacream");
		entityManager = factory.createEntityManager();
	}

	@Override
	public Profile create(String username, String email, Boolean active) {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		Profile profile= new Profile(username, email, active);
		entityManager.persist(profile);
		transactionsContext.commit();
		return profile;
	}

	@Override
	public Profile findByUsername(String username) {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		Profile profile = entityManager.find(Profile.class, username);
		transactionsContext.commit();
		return profile;
	}

	@Override
	public void update(Profile profile) {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		entityManager.merge(profile);
		transactionsContext.commit();
	}

	@Override
	public void deleteByUsername(String username) {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		entityManager.remove(entityManager.getReference(Profile.class, username));
		transactionsContext.commit();
	}

	@Override
	public List<Profile> findActive() {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		TypedQuery<Profile> query = entityManager.createQuery("select p from Profile as p where p.active = true", Profile.class);
		List<Profile> result = query.getResultList();
		transactionsContext.commit();
		return result;
	}

	@Override
	public List<Profile> findInactive() {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		TypedQuery<Profile> query = entityManager.createQuery("select p from Profile as p where p.active = false", Profile.class);
		List<Profile> result = query.getResultList();
		transactionsContext.commit();
		return result;
	}

	@Override
	public List<Profile> findMatching(String usernameFilter) {
		EntityTransaction transactionsContext = entityManager.getTransaction();
		transactionsContext.begin();
		TypedQuery<Profile> query = entityManager.createQuery("select p from Profile as p where p.username like :username", Profile.class);
		query.setParameter("username", usernameFilter);
		List<Profile> result = query.getResultList();
		transactionsContext.commit();
		return result;
	}
}
