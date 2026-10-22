package org.javacream.books;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Book {
 @Id private String isbn;
 private String title;
 private Integer pages;
 private Double price;
 private Boolean available;
 protected Book() {}
 public Book(String isbn,String title,Integer pages,Double price,Boolean available) { this.isbn=isbn;this.title=title;this.pages=pages;this.price=price;this.available=available; }
 public String getIsbn(){return isbn;} public String getTitle(){return title;} public Integer getPages(){return pages;} public Double getPrice(){return price;} public Boolean getAvailable(){return available;}
 public void setTitle(String v){title=v;} public void setPages(Integer v){pages=v;} public void setPrice(Double v){price=v;} public void setAvailable(Boolean v){available=v;}
}
