package com.table.sathi.model.order;

import com.table.sathi.dao.order.DeliveryAddress;
import com.table.sathi.dao.order.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("OrderDetails")
public class Order {
    @Id
    private String orderId;
    private String status;
    private String resturantId;
    private String restruantName;
    private LocalDateTime orderStartTime;
    private LocalDateTime finalBillingTime;
    private List<OrderItem> orderItemItems;
    private double subTotal;
    private GST gst;
    private DeliveryMethod deliveryMethod;
    private DeliveryAddress deliveryAddress;
    private double discountAmount;
    private String couponCode;
    private double total;
    private OrderStatus orderStatus;
}
