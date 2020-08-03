package org.javacream.training.java.books.warehouse.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.javacream.training.java.books.warehouse.api.Book;
import org.javacream.training.java.books.warehouse.api.BooksService;

public class JdbcBooksService implements BooksService {

	private Connection con;
	private PreparedStatement insertStatement;
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteByIdStatement;

	private static final String PREFIX = "ISBN:";
	private static final String COUNTRY_CODE = "-de";
	private PreparedStatement findAllTitlesStatement;
	private PreparedStatement findByAvailabilityStatement;
	private PreparedStatement findByPriceRangeStatement;
	private IsbnGenerator isbnGenerator;

	public JdbcBooksService() {
		String url = "jdbc:h2:tcp://192.168.178.48/~/books_db/test";
		String user = "sa";
		String password = "sa";
		try {
			con = DriverManager.getConnection(url, user, password);
			insertStatement = con.prepareStatement(
					"insert into books (isbn, title, price, pages, available) values(?1, ?2, ?3, ?4, ?5);");
			findAllStatement = con.prepareStatement("select * from books;");
			findByAvailabilityStatement = con.prepareStatement("select * from books where available = ?1;");
			findByPriceRangeStatement = con.prepareStatement("select * from books where price >= ?1 AND price <= ?2;");
			findByIdStatement = con.prepareStatement("select * from books where isbn = ?1;");
			updateStatement = con.prepareStatement(
					"update books set title = ?2, price=?3, pages=?4 , available=?5 where isbn = ?1;");
			deleteByIdStatement = con.prepareStatement("delete from books where isbn = ?1;");
			findAllTitlesStatement = con.prepareStatement("select title from books;");
			isbnGenerator = new IsbnGenerator();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public String create(String title, Double price, Integer pages, Boolean available) {
		try {
			String isbn = PREFIX + isbnGenerator.next() + COUNTRY_CODE;
			insertStatement.setString(1, isbn);
			insertStatement.setString(2, title);
			insertStatement.setDouble(3, price);
			insertStatement.setInt(4, pages);
			insertStatement.setBoolean(5, available);
			insertStatement.executeUpdate();
			return isbn;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Book findById(String isbn) {
		try {
			findByIdStatement.setString(1, isbn);
			ResultSet rs = findByIdStatement.executeQuery();
			rs.next();
			Book result = new Book(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5));
			return result;
		} catch (SQLException e) {
			// throw new RuntimeException(e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteById(String isbn) {
		try {
			deleteByIdStatement.setString(1, isbn);
			deleteByIdStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Book book) {
		try {
			updateStatement.setString(1, book.getIsbn());
			updateStatement.setString(2, book.getTitle());
			updateStatement.setDouble(3, book.getPrice());
			updateStatement.setInt(4, book.getPages());
			updateStatement.setBoolean(5, book.getAvailable());
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Book> findAll() {
		try {
			ResultSet rs = findAllStatement.executeQuery();
			return assemble(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Book> findAllAvailableBooks() {
		try {
			findByAvailabilityStatement.setBoolean(1, true);
			ResultSet rs = findByAvailabilityStatement.executeQuery();
			return assemble(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Book> findByPriceRange(double min, double max) {
		try {
			findByPriceRangeStatement.setDouble(1, min);
			findByPriceRangeStatement.setDouble(2, max);
			ResultSet rs = findByPriceRangeStatement.executeQuery();
			return assemble(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<String> allBookTitles() {
		try {
			ArrayList<String> result = new ArrayList<>();
			ResultSet rs = findAllTitlesStatement.executeQuery();
			while (rs.next()) {
				result.add(rs.getString(1));
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private List<Book> assemble(ResultSet rs) throws SQLException {
		ArrayList<Book> result = new ArrayList<>();
		while (rs.next()) {
			Book book = new Book(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5));
			result.add(book);
		}
		return result;

	}

	class IsbnGenerator {
		private PreparedStatement readActualIsbnStatement;
		private PreparedStatement writeIsbnStatement;

		public IsbnGenerator() throws SQLException {
			readActualIsbnStatement = con.prepareStatement("select isbn from ISBN");
			writeIsbnStatement = con.prepareStatement("update isbn set isbn = ?1");
		}

		int next() throws SQLException {
			ResultSet rs = readActualIsbnStatement.executeQuery();
			rs.next();
			int actuaIsbnNumber =  rs.getInt(1);
			actuaIsbnNumber++;
			writeIsbnStatement.setInt(1, actuaIsbnNumber);
			writeIsbnStatement.executeUpdate();
			return actuaIsbnNumber;

		}
	}
}
