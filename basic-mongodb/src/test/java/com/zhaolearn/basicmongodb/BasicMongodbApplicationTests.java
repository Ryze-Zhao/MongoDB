package com.zhaolearn.basicmongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicMongodbApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UseMongoTemplate useMongoTemplate;
    @Autowired
    private PeopleServiceImpl peopleService;

    @Test
    public void findAll() {
        List<People> peopleList=peopleService.findAll();
        System.out.println("Repository：");
        peopleList.stream().forEach(e->System.out.println(e.toString()));
        List<People> peopleList1=useMongoTemplate.findAll();
        System.out.println("Template：");
        peopleList1.stream().forEach(e->System.out.println(e.toString()));
    }



}
