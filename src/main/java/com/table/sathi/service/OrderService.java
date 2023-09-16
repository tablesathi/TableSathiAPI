package com.table.sathi.service;

import com.table.sathi.dao.order.OrderRequest;
import com.table.sathi.mapper.OrderMapper;
import com.table.sathi.mapper.RestaurantMapper;
import com.table.sathi.model.order.Order;
import com.table.sathi.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderRepo orderRepo;
    public Order createUpdateOrder(OrderRequest orderRequest) {
        Order  order=orderMapper.mapOrderRequestWithOrder(orderRequest);
        return orderRepo.save(order);
    }

    public Optional<Order> fetchOrder(String orderId) {
        //TODO currently the logic is assuming only one order is the final one
//        need to add logic for appending more order in same
        Optional<Order> optionalOrder= orderRepo.findById(orderId);
        return optionalOrder;
    }
}
