package org.javacream.training.java.profile.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.javacream.training.java.profile.api.Profile;
import org.javacream.training.java.profile.api.ProfileService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JpaProfileService implements ProfileService{
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	@Transactional
	public Profile create(String username, String email, Boolean active) {
		Profile profile= new Profile(username, email, active);
		entityManager.persist(profile);
		return profile;
	}

	@Override
	@Transactional
	public Profile findByUsername(String username) {
		Profile profile = entityManager.find(Profile.class, username);
		return profile;
	}

	@Override
	@Transactional
	public void update(Profile profile) {
		entityManager.merge(profile);
	}

	@Override
	@Transactional
	public void deleteByUsername(String username) {
		entityManager.remove(entityManager.getReference(Profile.class, username));
	}

	@Override
	@Transactional
	public List<Profile> findActive() {
		TypedQuery<Profile> query = entityManager.createQuery("select p from Profile as p where p.active = true", Profile.class);
		List<Profile> result = query.getResultList();
		return result;
	}

	@Override
	@Transactional
	public List<Profile> findInactive() {
		TypedQuery<Profile> query = entityManager.createQuery("select p from Profile as p where p.active = false", Profile.class);
		List<Profile> result = query.getResultList();
		return result;
	}

	@Override
	@Transactional
	public List<Profile> findMatching(String usernameFilter) {
		TypedQuery<Profile> query = entityManager.createQuery("select p from Profile as p where p.username like :username", Profile.class);
		query.setParameter("username", usernameFilter);
		List<Profile> result = query.getResultList();
		return result;
	}
}
