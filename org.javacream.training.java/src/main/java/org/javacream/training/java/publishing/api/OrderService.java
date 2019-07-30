package org.javacream.training.java.publishing.api;

import org.javacream.training.java.publishing.api.types.Order;

public interface OrderService {

	Order order(String isbn, int number);
}
