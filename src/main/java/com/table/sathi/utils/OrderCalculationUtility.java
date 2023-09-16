package com.table.sathi.utils;

import com.table.sathi.model.order.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderCalculationUtility {

    public OrderCalculationResult calculateGSTAndTotal(List<OrderItem> orderItems) {
        double totalAmount = 0.0;
        double totalCGST = 0.0;
        double totalSGST = 0.0;

        for (OrderItem item : orderItems) {
            double itemTotal = item.getItemQuantity() * item.getItemPrice();
            totalAmount += itemTotal;

            // Calculate CGST and SGST for each item based on its individual GST rate
            double itemCGST = (itemTotal * item.getGstRate().getCgstRate()) / 100.0;
            double itemSGST = (itemTotal * item.getGstRate().getSgstRate()) / 100.0;

            totalCGST += itemCGST;
            totalSGST += itemSGST;
        }

        // Calculate the total GST and subtotal
        double totalGST = totalCGST + totalSGST;
        double subtotal = totalAmount;

        // Calculate the grand total including GST
        totalAmount = subtotal + totalGST;
        return OrderCalculationResult
                .builder()
                .totalSGST(totalSGST)
                .totalCGST(totalCGST)
                .subtotal(subtotal)
                .totalAmount(totalAmount)
                        .build();
//
//
//        // You can log or return the calculated values as needed
//        System.out.println("Subtotal: " + subtotal);
//        System.out.println("Total CGST: " + totalCGST);
//        System.out.println("Total SGST: " + totalSGST);
//        System.out.println("Total GST: " + totalGST);
//        System.out.println("Grand Total: " + grandTotal);
    }
}
