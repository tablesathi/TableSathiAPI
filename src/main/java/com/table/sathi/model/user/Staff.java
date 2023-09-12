package com.table.sathi.model.user;

import com.table.sathi.model.role.StaffRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("Staff")

public class Staff {
    @Id
    private Long id;

//    it should be unique
    private Long RestaurantId;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private StaffRole role; // Enum: ADMIN, STAFF, CUSTOMER

    private String phoneNumber;

    private String address;

    private LocalDate dateOfBirth;

    private Boolean isActive;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}

