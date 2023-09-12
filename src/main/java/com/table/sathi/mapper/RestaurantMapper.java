package com.table.sathi.mapper;

import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.model.menu.RestaurantInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestaurantMapper {
    public RestaurantInfo mapRestaurantInfoRequestToRestaurantInfo(RestaurantInfoRequest restaurantInfoRequest)
    {
        return RestaurantInfo.builder()
                .id(restaurantInfoRequest.getId())
                .name(restaurantInfoRequest.getName())
                .location(restaurantInfoRequest.getLocation())
                .menu(restaurantInfoRequest.getMenu())
                .isActive(restaurantInfoRequest.isActive())
                .isLive(restaurantInfoRequest.isLive())
                .restroEmail(restaurantInfoRequest.getRestroEmail())
                .phoneNumber(restaurantInfoRequest.getPhoneNumber())
                .restroLogo(restaurantInfoRequest.getRestroLogo())
                .restroActiveTiming(restaurantInfoRequest.getRestroActiveTiming())
                .lastUpdatedTs( LocalDateTime.now())
                .build();
        //test
    }
}
