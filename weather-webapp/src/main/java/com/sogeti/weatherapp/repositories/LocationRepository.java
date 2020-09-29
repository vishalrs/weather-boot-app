package com.sogeti.weatherapp.repositories;

import com.sogeti.weatherapp.common.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

        Location findByCity(String city);

}
