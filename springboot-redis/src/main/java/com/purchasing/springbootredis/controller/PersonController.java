package com.purchasing.springbootredis.controller;

import com.purchasing.springbootredis.entity.Person;
import com.purchasing.springbootredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    @Qualifier(value = "redisRepository")
    private PersonRepository repository;

    @PostMapping(value = "save")
    public boolean save(@RequestBody Person person){
        return repository.save(person);
    }

    @GetMapping(value = "{id}")
    public Person selectById(@PathVariable(value = "id") Long id){
        return repository.selectById(id);
    }

    @GetMapping(value = "list")
    public List<Person> selectAll(){
        return repository.selectAll();
    }
}
