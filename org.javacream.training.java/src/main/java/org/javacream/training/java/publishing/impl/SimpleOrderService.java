package org.javacream.training.java.publishing.impl;

import java.util.Random;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.OrderService;
import org.javacream.training.java.publishing.api.StoreService;
import org.javacream.training.java.publishing.api.types.Book;
import org.javacream.training.java.publishing.api.types.Order;
import org.javacream.training.java.publishing.api.types.Order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleOrderService implements OrderService {

	@Autowired private BooksService booksService;
	@Autowired private StoreService storeService;
	private Random random = new Random();
	@Override
	public Order order(String isbn, int number) {
		Book book = booksService.findBookByIsbn(isbn);
		OrderStatus orderStatus = Order.OrderStatus.UNAVAILABLE;
		long orderId = random.nextLong();
		double totalPrice = 0;
		if (book != null) {
			totalPrice = number * book.getPrice();
			int stock = storeService.getStock("books", isbn);
			if (stock >= number) {
				orderStatus = OrderStatus.OK;
			}else {
				orderStatus = OrderStatus.PENDING;
			}
		}
		return new Order(orderId, isbn, number, totalPrice, orderStatus);
	}

}
