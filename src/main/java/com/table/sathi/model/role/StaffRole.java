package com.table.sathi.model.role;

public enum StaffRole {
    NORMAL,     // Normal staff with no special menu editing permissions
    ADMIN_EDIT, // Staff with menu editing permissions
    VIEW_ONLY   // Staff with read-only access to the menu
}