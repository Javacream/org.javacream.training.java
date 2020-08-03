package org.javacream.training.java.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
		
		String sqlStatement = "select isbn, title, price from books";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sqlStatement);
		while(result.next()) {
			System.out.println(result.getString(3));
		}
		result.close();
		statement.close();
		con.close();
	}
}
