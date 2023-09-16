package com.table.sathi.dao.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GSTRate {
    private double cgstRate;
    private double sgstRate;
}
