package org.javacream.training.java.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class SimpleJdbcTest {

	@Test public void testH2Database() throws SQLException {
		String url = "jdbc:h2:tcp://192.168.178.48/~/books_db/test";
		String user = "sa";
		String password = "sa";
				
		Connection con = DriverManager.getConnection(url, user, password);
		Assert.assertNotNull(con);
		
		String whereClause = "%i%";
		//VORSICHT: Statements sind Security-Anfällig! SQL-Injection
//		String sqlStatement = "select * from books where title like '" + whereClause + "';";
//		Statement statement = con.createStatement();
//		ResultSet queryResult = statement.executeQuery(sqlStatement);
//		while(queryResult.next()) {
//			System.out.println(queryResult.getString(2));
//		}
		
		String sqlPreparedStatement = "select * from books where title like ?1;";
		PreparedStatement preparedStatement = con.prepareStatement(sqlPreparedStatement);
		preparedStatement.setString(1, whereClause);
		ResultSet queryResult = preparedStatement.executeQuery();
		while(queryResult.next()) {
			System.out.println(queryResult.getString(2));
		}
		
		
		
		
//		String insertStatement = "insert into books (isbn, title, price, pages, available) values('ISBN6', 'Linux', 9.99, 2500, 'true');";
//		int numberOfRows = statement.executeUpdate(insertStatement);
//		Assert.assertEquals(1, numberOfRows);

//		String deleteStatement = "delete from  books;";
//		int numberOfRows = statement.executeUpdate(deleteStatement);
//		Assert.assertEquals(6, numberOfRows);

		
		queryResult.close();
		preparedStatement.close();
		con.close();
	}
}
