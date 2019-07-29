package org.javacream.training.java.publishing;

public class SpecialistBook extends Book {

	private String subject;
	public SpecialistBook(String isbn, String title, String subject) {
		super(isbn, title);
		this.subject= subject;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SpecialistBook [subject=" + subject + ", toString()=" + super.toString() + "]";
	}
	public String getSubject() {
		return subject;
	}

}
