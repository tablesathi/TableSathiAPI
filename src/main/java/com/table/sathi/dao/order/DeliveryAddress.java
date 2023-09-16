package com.table.sathi.dao.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryAddress {
    private String streetAddress;
    private String city;
    private String postalCode;
    private String country;
}
