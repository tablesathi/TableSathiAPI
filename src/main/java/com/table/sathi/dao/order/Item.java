package com.table.sathi.dao.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private String itemId;
    private int quantity;
//    private GSTRate gstRate;
}
