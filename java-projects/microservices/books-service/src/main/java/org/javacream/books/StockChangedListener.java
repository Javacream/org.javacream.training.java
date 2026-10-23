package org.javacream.books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
@Component
public class StockChangedListener {
 @Autowired private BookController controller;
 @KafkaListener(topics="store.stock.changed",groupId="books-service")
 public void onStockChanged(StockChangedEvent event){
  if("books".equals(event.category()) && event.stock()!=null) controller.updateAvailability(event.itemId(),event.stock()>0);
 }
}
