package com.table.sathi.dao;

import com.table.sathi.model.menu.LocationInfo;
import com.table.sathi.model.menu.Menu;
import com.table.sathi.model.menu.RestroActiveTiming;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class RestaurantInfoRequest {
    private String id;
    private String name;
    private LocationInfo location;
    private Menu menu;
    private boolean isActive;
    private boolean isLive;
    private String restroEmail;
    private String phoneNumber;
    private String restroLogo;
    private RestroActiveTiming restroActiveTiming;
}
