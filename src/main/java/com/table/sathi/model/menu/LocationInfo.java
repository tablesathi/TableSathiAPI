package com.table.sathi.model.menu;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationInfo {
    private String restroName;
    private String restroLocation; // You can also use a separate class for Lat and Long if needed
    private String city;
    private String pincode;
}
