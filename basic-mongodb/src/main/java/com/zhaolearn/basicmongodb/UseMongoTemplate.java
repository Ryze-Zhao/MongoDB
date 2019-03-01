package com.zhaolearn.basicmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class UseMongoTemplate {
    @Autowired
    private MongoTemplate mongotemplate;
    public List<People> findAll(){
        List<People>  peopleList = mongotemplate.findAll(People.class);
        return peopleList;
    }
    public People findName(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        People people= mongotemplate.findOne(query,People.class);
        return people;
    }
    public List<People> saveList(List<People> peopleList) {
        Collection<People> peopleList1=mongotemplate.insert(peopleList,People.class);
        return new ArrayList(peopleList1);
    }
}
