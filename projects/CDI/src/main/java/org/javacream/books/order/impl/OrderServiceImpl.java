package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

        @Autowired
        private BooksService booksService;
        @Autowired
        private StoreService storeService;
        @Autowired
        private IdGenerator idGenerator;
        @Override
        public Order order(String isbn, int amount) {
            OrderStatus orderStatus;
            double totalPrice = 0;

            try{
                Book book = booksService.findBookByIsbn(isbn);
                totalPrice = amount * book.getPrice();
                if (storeService.getStock("books", isbn) >= amount){
                    orderStatus = OrderStatus.OK;
                }else{
                    orderStatus = OrderStatus.PENDING;
                }
            }
            catch(BookException e){
                orderStatus = OrderStatus.UNAVAILABLE;
            }
            Order order = new Order(idGenerator.nextId(), isbn, amount, totalPrice, orderStatus);
            return order;
        }

}
