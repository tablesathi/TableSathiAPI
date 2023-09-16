package com.table.sathi.mapper;

import com.table.sathi.constant.SathiConstant;
import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.dao.order.Item;
import com.table.sathi.dao.order.OrderRequest;
import com.table.sathi.exception.ErrorResponse;
import com.table.sathi.exception.RestaurantInfoException;
import com.table.sathi.model.menu.MenuCategory;
import com.table.sathi.model.menu.MenuItem;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.model.order.GST;
import com.table.sathi.model.order.Order;
import com.table.sathi.model.order.OrderItem;
import com.table.sathi.service.RestaurantInfoService;
import com.table.sathi.utils.OrderCalculationResult;
import com.table.sathi.utils.OrderCalculationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static com.table.sathi.utils.SathiUtils.buildErrorResponse;

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
