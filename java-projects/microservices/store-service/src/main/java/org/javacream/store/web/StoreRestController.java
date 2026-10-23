package org.javacream.store.web;
import java.util.List;
import org.javacream.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/store")
public class StoreRestController {
 @Autowired private StoreController controller;
 @GetMapping public List<StoreEntry> findAll(){return controller.findAll();}
 @GetMapping("/{category}/{itemId}") public StoreEntry find(@PathVariable String category,@PathVariable String itemId){return controller.find(category,itemId);}
 @PutMapping("/{category}/{itemId}/stock/{stock}") public StoreEntry updateStock(@PathVariable String category,@PathVariable String itemId,@PathVariable Integer stock){return controller.updateStock(category,itemId,stock);}
}
