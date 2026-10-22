package org.javacream.store;
import jakarta.persistence.*;
@Entity @Table(uniqueConstraints=@UniqueConstraint(columnNames={"category","item_id"}))
public class StoreEntry {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String category;
 @Column(name="item_id") private String itemId;
 private Integer stock;
 protected StoreEntry() {}
 public StoreEntry(String category,String itemId,Integer stock){this.category=category;this.itemId=itemId;this.stock=stock;}
 public Long getId(){return id;} public String getCategory(){return category;} public String getItemId(){return itemId;} public Integer getStock(){return stock;}
 public void setStock(Integer stock){this.stock=stock;}
}
