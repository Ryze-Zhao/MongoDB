package com.zhaolearn.basicmongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

    @Test
    public void findName() {
        String name="test03";
        People people=peopleService.findName(name);
        System.out.println("Repository：");
        System.out.println(people.toString());
        People people1=useMongoTemplate.findName(name);
        System.out.println("Template：");
        System.out.println(people1.toString());
    }

    @Test
    public void saveList() {
        List<People> peopleList = new ArrayList<>();
        List<People> peopleList1 = new ArrayList<>();
        for (int i = 50; i < 55; i++) {
            People e = new People("Template" + i,i + "");
            peopleList.add(e);
        }
        for (int i = 55; i < 60; i++) {
            People e = new People("Repository" + i,i + "");
            peopleList1.add(e);
        }
        //由于执行后，会令Entity从新建状态变为持久状态,那么第二次存的时候，也就是原来的数据，所以需要分开List
        useMongoTemplate.saveList(peopleList);
        peopleService.saveList(peopleList1);
    }
    @Test
    public void updatePeople() {
        People people50=peopleService.findName("Template50");
        People people51=peopleService.findName("Template51");
        people50.setName("111111111");
        people51.setName("222222222");
        peopleService.updatePeople(people50);
        useMongoTemplate.updatePeople(people51);
    }

    @Test
    public void deletePeopleByID() {
        peopleService.deletePeopleByID("5c78cc6ab872fc0b243ccc35");
        useMongoTemplate.deletePeopleByID("5c78cc6ab872fc0b243ccc36");
    }
}
