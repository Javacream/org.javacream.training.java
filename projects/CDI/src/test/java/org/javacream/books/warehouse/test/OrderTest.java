package org.javacream.books.warehouse.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

        @Autowired private OrderService orderService;

        @Test
        public void order40Isbn1CreatesOkOrder(){
            Order order = orderService.order("Isbn1", 40);
            Assertions.assertEquals(OrderStatus.OK, order.getOrderStatus());
        }
        @Test public void order50Isbn1CreatesPendingOrder(){
            Order order = orderService.order("Isbn1", 50);
            Assertions.assertEquals(OrderStatus.PENDING, order.getOrderStatus());
        }
        @Test public void order50UnknownIsbnCreatesUnavailableOrder(){
            Order order = orderService.order("UnknownIsbn", 50);
            Assertions.assertEquals(OrderStatus.UNAVAILABLE, order.getOrderStatus());
        }

    }