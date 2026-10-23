package org.javacream.books;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@ActiveProfiles("test")
public class DatabaseTest {

	@Autowired private DataSource dataSource;
	@PersistenceContext private EntityManager entityManager;
	
	@Test public void checkDatabaseAvailable(){
		Assertions.assertNotNull(dataSource);
	}
	@Test 
	public void completelyOutdatedDataAccess() throws Exception{
		var connection = dataSource.getConnection();
		var statement = connection.createStatement();
		var result = statement.executeQuery("select * from messages");
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		connection.close();
	}
	
	@Test 
	public void dataAccess() {
		var query = entityManager.createNativeQuery("select * from messages");
		var resultList = query.getResultList();
		for (Object row: resultList) {
			System.out.println(row);
		}
	}
}
