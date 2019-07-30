package org.javacream.training.java.publishing.app;

import javax.annotation.PostConstruct;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderingApplication {

	@Autowired
	private OrderService orderService;
	
	@PostConstruct
	public void start() {
		System.out.println(orderService.order("ISBN1", 5));
		System.out.println(orderService.order("ISBN1", 5000));
		System.out.println(orderService.order("UNKNOWN_ISBN1", 1));
		
	}
}
