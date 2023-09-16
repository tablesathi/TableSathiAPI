package com.table.sathi.controller.interfaceController;

import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.model.menu.RestaurantInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface RestaurantInfoControllerApi {

    @Operation(summary = "It will be used to create and update restaurant menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "It will be used to create and update restaurant menu"),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error")
    })
    ResponseEntity<RestaurantInfo> createUpdateRestaurant(RestaurantInfoRequest restaurantInfoRequest);

    @Operation(summary = "It will be used to fetch restaurant menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "It will be used to fetch restaurant menu"),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error")
    })
    ResponseEntity<RestaurantInfo> fetchRestaurant(String resturentId);



    @Operation(summary = "It will be used to delete restaurant menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "It will be used to delete restaurant menu"),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error")
    })
    ResponseEntity<Void> deleteRestaurant(String resturentId);
    
}