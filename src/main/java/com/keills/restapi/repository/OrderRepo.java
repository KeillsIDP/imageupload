package com.keills.restapi.repository;

import com.keills.restapi.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order,Long> {
}
