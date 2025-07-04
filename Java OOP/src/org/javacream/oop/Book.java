package org.javacream.oop;

import java.util.Objects;

public class Book {

	private String isbn;
	private String title;
	private Integer pages;
	private Double price;
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", price=" + price + "]";
	}
	public String getIsbn() {
		return isbn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}
	public Book(String isbn, String title, Integer pages, Double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public Integer getPages() {
		return pages;
	}
	public Double getPrice() {
		return price;
	}
}
