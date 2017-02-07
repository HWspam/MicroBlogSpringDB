package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by erikjakubowski on 2/7/17.
 */
public interface UserRepo extends CrudRepository<User, Integer>{
    User findFirstByName(String name);

}
