package com.table.sathi.model.menu;

import com.table.sathi.dao.order.GSTRate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
    private String menuItemId;
    private String title;
    private String description;
    private int cost;
    private String prepTime;
    private String imageSrc;
    private GSTRate gstRate;
//need to check with Up. Ui will generate unique ID
//    public void generateMenuItemId(String categoryName, int nextItemNumber) {
//        // Concatenate the category name and the auto-incremented number to form the menu item's ID
//        this.menuItemId = categoryName + "_" + String.format("%04d", nextItemNumber);
//    }
}
