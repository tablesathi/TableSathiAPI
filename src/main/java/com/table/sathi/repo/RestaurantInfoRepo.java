package com.table.sathi.repo;

import com.table.sathi.model.menu.RestaurantInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantInfoRepo extends MongoRepository<RestaurantInfo,String> {
}
