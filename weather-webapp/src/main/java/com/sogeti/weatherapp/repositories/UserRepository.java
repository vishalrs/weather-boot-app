package com.sogeti.weatherapp.repositories;

import com.sogeti.weatherapp.common.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    @Query("select u from User u where u.firstname=substring(:name, 0, locate(',',:name)-1) " +
            "and u.lastname=substring(:name, locate(',', :name)+1, length(:name))")
    User findByName(@Param("name") String name);
}
