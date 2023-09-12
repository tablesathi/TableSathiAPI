package com.table.sathi.service;

import com.table.sathi.constant.SathiConstant;
import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.exception.ErrorResponse;
import com.table.sathi.exception.RestaurantInfoException;
import com.table.sathi.mapper.RestaurantMapper;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.repo.RestaurantInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.table.sathi.utils.SathiUtils.buildErrorResponse;

@Service
public class RestaurantInfoService {
    @Autowired
    RestaurantInfoRepo restaurantInfoRepo;
    @Autowired
    RestaurantMapper restaurantMapper;

    public RestaurantInfo createUpdateResturant(RestaurantInfoRequest restaurantInfoRequest) {
        RestaurantInfo restaurantInfo=restaurantMapper.mapRestaurantInfoRequestToRestaurantInfo(restaurantInfoRequest);
        try {
            return restaurantInfoRepo.save(restaurantInfo);
        } catch (Exception exception) {
            ErrorResponse errorResponse = buildErrorResponse(
                    SathiConstant.RESTAURANT_INFO_SAVE_ERROR_MESSAGE,
                    SathiConstant.DEFAULT_EXCEPTION_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    exception
            );
            throw new RestaurantInfoException(errorResponse);
        }
    }

    public Optional<RestaurantInfo> fetchResturant(String restaurantId) {
        try {
            return restaurantInfoRepo.findById(restaurantId);
        } catch (Exception exception) {
            ErrorResponse errorResponse = buildErrorResponse(
                    SathiConstant.RESTAURANT_INFO_SAVE_ERROR_MESSAGE,
                    SathiConstant.DEFAULT_EXCEPTION_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    exception
            );
            throw new RestaurantInfoException(errorResponse);
        }
    }
}
