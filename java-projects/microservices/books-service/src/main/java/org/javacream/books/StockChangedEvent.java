package org.javacream.books;
public record StockChangedEvent(String category,String itemId,Integer stock) {}
