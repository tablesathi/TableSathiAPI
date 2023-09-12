//package com.table.sathi.controller;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//@OpenAPIDefinition(info = @Info(
//        title = "TableSathi API",
//        version = "1.0.0",
//        description = "This API is used to create,update,delete and fetch the Account Info ",
//        contact = @Contact(
//                name = "Gaurav Rai",
//                email = "gaurav18.2013@gmail.com")
//))
//@RestController
//@RequestMapping("/account")
//public class AccountController {
//    @Operation(summary = "Register a new user")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "User registered successfully"),
//            @ApiResponse(responseCode = "400", description = "Invalid input"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    @PostMapping("/register")
//    public ResponseEntity<Object> registerUser(@RequestBody Object user) {
////        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
//        return null;
//    }
//
//}
