package com.table.sathi.model.menu;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    private List<MenuCategory> menu;
}
