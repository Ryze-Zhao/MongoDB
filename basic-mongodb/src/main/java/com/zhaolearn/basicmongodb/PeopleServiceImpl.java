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
}
