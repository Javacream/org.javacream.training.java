package org.javacream.training.java.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JpaTest {

	@Test 
	public void jpaWorks() {
		//Parse die persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.javacream");
		//Erzeuge eine JPA-Infrastruktur
		EntityManager entityManager = factory.createEntityManager();
		entityManager.close();
	}
}
