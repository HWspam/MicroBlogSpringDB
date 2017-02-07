package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by erikjakubowski on 12/22/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByUser(User coolguy);
}
