package org.javacream.store;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class StoreController {
 @Autowired private StoreRepository repository;
 @Autowired private KafkaTemplate<String,StockChangedEvent> kafka;
 public List<StoreEntry> findAll(){return repository.findAll();}
 public StoreEntry find(String category,String itemId){return repository.findByCategoryAndItemId(category,itemId).orElse(null);}
 public StoreEntry updateStock(String category,String itemId,Integer stock){
  if(stock==null||stock<0)throw new IllegalArgumentException("stock must be nonnegative");
  StoreEntry entry=repository.findByCategoryAndItemId(category,itemId).orElseGet(()->new StoreEntry(category,itemId,stock));
  entry.setStock(stock);entry=repository.save(entry);
  kafka.send("store.stock.changed",category+":"+itemId,new StockChangedEvent(category,itemId,stock));
  return entry;
 }
}
