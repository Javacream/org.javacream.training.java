package org.javacream.training.java.books.warehouse.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.javacream.training.java.books.warehouse.api.Book;
import org.javacream.training.java.books.warehouse.api.BooksService;

public class JpaBooksService implements BooksService {
	private EntityManager entityManager;
	private static final String PREFIX = "ISBN:";
	private static final String COUNTRY_CODE = "-de";
	private Random random = new Random(this.hashCode() + System.currentTimeMillis());
	
	public JpaBooksService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.javacream");
		entityManager = factory.createEntityManager();
	}
	@Override
	public String create(String title, Double price, Integer pages, Boolean available) {
		Integer key = Math.abs(random.nextInt());
		String isbn = PREFIX + key + COUNTRY_CODE;
		Book newBook = new Book (isbn, title, price, pages, available);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(newBook);
		transaction.commit();
		return isbn;
	}

	@Override
	public Book findById(String isbn) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Book result =  entityManager.find(Book.class, isbn);
		transaction.commit();
		return result;
		
	}

	@Override
	public void deleteById(String isbn) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(entityManager.getReference(Book.class, isbn));
		transaction.commit();
	}

	@Override
	public void update(Book book) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(book);
		transaction.commit();
	}

	@Override
	public List<Book> findAll() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Book> result = entityManager.createQuery("select b from Book as b", Book.class).getResultList();
		transaction.commit();
		return result;
	}

	@Override
	public List<Book> findAllAvailableBooks() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Book> result = entityManager.createQuery("select b from Book as b where b.available = true", Book.class).getResultList();
		transaction.commit();
		return result;
	}

	@Override
	public List<Book> findByPriceRange(double min, double max) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		TypedQuery<Book> query = entityManager.createQuery("select b from Book as b where b.price  >= :min and b.price <= :max", Book.class);
		query.setParameter("min", min);
		query.setParameter("max", max);
		List<Book> result = query.getResultList();
		transaction.commit();
		return result;
	}

	@Override
	public List<String> allBookTitles() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<String> result = entityManager.createQuery("select b.title from Book as b", String.class).getResultList();
		transaction.commit();
		return result;
	}

}
