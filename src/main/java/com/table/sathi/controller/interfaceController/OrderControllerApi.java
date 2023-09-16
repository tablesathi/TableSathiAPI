package com.table.sathi.controller.interfaceController;

import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.dao.order.OrderRequest;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.model.order.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface OrderControllerApi {

    @Operation(summary = "It will be used to create and update restaurant order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "It will be used to create and update restaurant order"),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error")
    })
    ResponseEntity<Order> createUpdateRestaurant(OrderRequest orderRequest);

    @Operation(summary = "It will be used to fetch restaurant order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "It will be used to fetch restaurant order"),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error")
    })
    ResponseEntity<Order> fetchRestaurant(String orderId);

}
