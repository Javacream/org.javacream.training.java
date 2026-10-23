package org.javacream.store;
public record StockChangedEvent(String category,String itemId,Integer stock) {}
