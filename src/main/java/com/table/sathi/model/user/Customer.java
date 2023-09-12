package com.table.sathi.model.user;

import com.table.sathi.model.role.CustomerRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document("Customer")
public class Customer {
    @Id
    private Long id;

    private Long RestaurantId;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private LocalDate dateOfBirth;

    private Boolean isActive;

    private CustomerRole role;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    //here use the OrderHistory Object it will have basic info od the order
    private List<Object> orderHistory;
}
