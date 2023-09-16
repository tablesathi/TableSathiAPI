package com.table.sathi.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GST {
    private double cgstRate;
    private double sgstRate;
    private double cgstAmount;
    private double sgstAmount;
}
