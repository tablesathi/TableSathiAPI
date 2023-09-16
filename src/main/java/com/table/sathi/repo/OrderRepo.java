package com.table.sathi.repo;

import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.model.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order,String> {
}
