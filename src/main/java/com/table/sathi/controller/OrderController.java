package com.table.sathi.controller;

import com.table.sathi.controller.interfaceController.OrderControllerApi;
import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.dao.order.OrderRequest;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.model.order.Order;
import com.table.sathi.service.OrderService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@OpenAPIDefinition(info = @Info(
        title = "TableSathi API",
        version = "1.0.0",
        description = "This API is used to create,update,delete and fetch the resturant order details ",
        contact = @Contact(
                name = "Gaurav Rai",
                email = "gaurav18.2013@gmail.com")
))
@RestController
@RequestMapping("/api/order")
public class OrderController implements OrderControllerApi {
    @Autowired
    OrderService orderService;
    @RequestMapping(method = RequestMethod.POST,path = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Order> createUpdateRestaurant(@RequestBody OrderRequest orderRequest) {

        return ResponseEntity.ok(orderService.createUpdateOrder(orderRequest));
    }


    @RequestMapping(method = RequestMethod.GET,path = "/{orderId}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Order> fetchRestaurant(@PathVariable String orderId) {
        Optional<Order> order=orderService.fetchOrder(orderId);
        if(order.isPresent())
        {
            return ResponseEntity.ok(order.get());
        }
        else return ResponseEntity.notFound().build();
    }
}
