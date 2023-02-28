package org.javacream.training.java.publishing;

public class SpecialistBook extends Book{
    private String subject;
    public SpecialistBook(String isbn, String title, Double price, String subject) {
        super(isbn, title, price);
        this.subject = subject;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
