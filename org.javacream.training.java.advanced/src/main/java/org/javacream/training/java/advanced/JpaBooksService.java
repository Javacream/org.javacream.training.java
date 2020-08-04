package org.javacream.training.java.advanced;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class JpaBooksService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void doDemo() {
		System.out.println(entityManager);
	}
}
