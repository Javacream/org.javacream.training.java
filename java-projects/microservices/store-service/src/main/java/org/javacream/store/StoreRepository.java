package org.javacream.store;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StoreRepository extends JpaRepository<StoreEntry,Long> { Optional<StoreEntry> findByCategoryAndItemId(String category,String itemId); }
