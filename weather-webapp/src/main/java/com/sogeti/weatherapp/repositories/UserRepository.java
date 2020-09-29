package com.sogeti.weatherapp.repositories;

import com.sogeti.weatherapp.common.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}
