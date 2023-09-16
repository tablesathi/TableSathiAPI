package com.table.sathi.dao.order;

import com.table.sathi.model.order.DeliveryMethod;
import com.table.sathi.model.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private String orderId;
    private String resturantId;
    private String restruantName;
    private String orderFinalStatus;
    private List<Item> items;
    private String couponCode;
    private DeliveryMethod deliveryMethod;
    private DeliveryAddress deliveryAddress;
    private OrderStatus orderStatus;
}
