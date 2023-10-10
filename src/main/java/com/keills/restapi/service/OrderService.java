package com.keills.restapi.service;

import com.keills.restapi.model.Order;
import com.keills.restapi.exception.OrderNotFoundException;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<Object> getOrders();
    ResponseEntity<Object> createOrder(Order order);
    ResponseEntity<Object> deleteOrder(Long id) throws OrderNotFoundException;
}
