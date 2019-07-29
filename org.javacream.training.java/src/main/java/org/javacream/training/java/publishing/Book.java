package org.javacream.training.java.publishing;

public class Book {

	private String isbn;
	private String title;
	private int pages;
	private double price;
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", price=" + price + "]";
	}
	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
}
