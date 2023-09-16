package com.table.sathi.service;

import com.table.sathi.constant.SathiConstant;
import com.table.sathi.dao.RestaurantInfoRequest;
import com.table.sathi.exception.ErrorResponse;
import com.table.sathi.exception.RestaurantInfoException;
import com.table.sathi.mapper.RestaurantMapper;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.repo.RestaurantInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.table.sathi.utils.SathiUtils.buildErrorResponse;

@Service
@Slf4j
public class RestaurantInfoService {
    @Autowired
    RestaurantInfoRepo restaurantInfoRepo;
    @Autowired
    RestaurantMapper restaurantMapper;
    @CacheEvict(value = "restaurants", key = "#restaurantId")
    public RestaurantInfo createUpdateResturant(RestaurantInfoRequest restaurantInfoRequest,String restaurantId) {
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
    @Cacheable(value = "restaurants", key = "#restaurantId")
    public Optional<RestaurantInfo> fetchResturant(String restaurantId) {
        try {
            log.info("1234512345","under fetchResturant method");
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

    public void deleteResturent(String resturentId) {
        try {
             restaurantInfoRepo.deleteById(resturentId);
        } catch (Exception exception) {
            ErrorResponse errorResponse = buildErrorResponse(
                    "Error while deleting",
                    SathiConstant.DEFAULT_EXCEPTION_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    exception
            );
            throw new RestaurantInfoException(errorResponse);
        }
    }
}
