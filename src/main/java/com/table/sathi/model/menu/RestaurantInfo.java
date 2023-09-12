package com.table.sathi.model.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("RestaurantInfo")
public class RestaurantInfo {
    @Id
    private String id;
    private String name;
    private LocationInfo location;
    private Menu menu;
    @LastModifiedDate
    private LocalDateTime lastUpdatedTs;
    @CreatedDate
    private LocalDateTime createdTs;
    private boolean isActive;
    private boolean isLive;
    private String restroEmail;
    private String phoneNumber;
    private String restroLogo;
    private RestroActiveTiming restroActiveTiming;

}
