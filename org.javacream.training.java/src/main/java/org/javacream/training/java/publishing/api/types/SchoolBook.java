package org.javacream.training.java.publishing.api.types;

public class SchoolBook extends Book {

	private int year;
	private String topic;
	public SchoolBook(String isbn, String title, int year, String topic) {
		super(isbn, title);
		this.year = year;
		this.topic = topic;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SchoolBook [year=" + year + ", topic=" + topic + ", toString()=" + super.toString() + "]";
	}
	public int getYear() {
		return year;
	}
	public String getTopic() {
		return topic;
	}

}
