package com.zhaolearn.basicmongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepository extends MongoRepository<People, String> {
    People findByName(String name);
}