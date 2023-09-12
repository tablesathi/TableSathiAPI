package com.table.sathi.model.menu;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestroActiveTiming {
    @Builder.Default
    private String startTime= "11AM";
    @Builder.Default
    private String endTime= "11PM";
}
