package com.table.sathi.controller;

import com.table.sathi.controller.interfaceController.RestaurantInfoControllerApi;
import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.service.RestaurantInfoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@OpenAPIDefinition(info = @Info(
        title = "TableSathi API",
        version = "1.0.0",
        description = "This API is used to create,update,delete and fetch the resturant Info ",
        contact = @Contact(
                name = "Gaurav Rai",
                email = "gaurav18.2013@gmail.com")
))
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantInfoController implements RestaurantInfoControllerApi {

    @Autowired
    RestaurantInfoService restaurantInfoService;
    @Override
    @RequestMapping(method = RequestMethod.POST,path = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantInfo> createUpdateRestaurant(@RequestBody RestaurantInfoRequest restaurantInfoRequest) {

       return ResponseEntity.ok(restaurantInfoService.createUpdateResturant(restaurantInfoRequest));
    }
    @RequestMapping(method = RequestMethod.GET,path = "/{resturentId}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<RestaurantInfo> fetchRestaurant(@PathVariable String resturentId) {
        Optional<RestaurantInfo> restaurantInfo=restaurantInfoService.fetchResturant(resturentId);
        if(restaurantInfo.isPresent())
        {
            return ResponseEntity.ok(restaurantInfo.get());
        }
        else return ResponseEntity.notFound().build();
    }
}
