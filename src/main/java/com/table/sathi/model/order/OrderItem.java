package com.table.sathi.model.order;

import com.table.sathi.dao.order.GSTRate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private String itemId;
    private String itemTitle;
    private int itemQuantity;
    private double itemPrice;
    private String itemType;
    private String imageLink;
    private LocalDateTime itemOrderTime;
    private GSTRate gstRate;

}
