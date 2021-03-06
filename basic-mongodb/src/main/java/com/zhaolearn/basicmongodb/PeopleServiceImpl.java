package com.zhaolearn.basicmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PeopleServiceImpl {
    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> findAll() {
       return peopleRepository.findAll();
    }


    public People findName(String name) {
        People people=peopleRepository.findByName(name);
        return people;
    }

    public List<People> saveList(List<People> peopleList) {
        return peopleRepository.saveAll(peopleList);
    }

    public void updatePeople(People people) {
        peopleRepository.save(people);
    }

    public void deletePeopleByID(String id) {
        peopleRepository.deleteById(id);
    }
}
