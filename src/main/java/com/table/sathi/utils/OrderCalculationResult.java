package com.table.sathi.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCalculationResult {
    private double totalAmount;
    private double totalCGST;
    private double totalSGST;
    private double subtotal;

}
