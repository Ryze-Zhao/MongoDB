package com.zhaolearn.basicmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UseMongoTemplate {
    @Autowired
    private MongoTemplate mongotemplate;
    public List<People> findAll(){
        List<People>  peopleList = mongotemplate.findAll(People.class);
        return peopleList;
    }
}
