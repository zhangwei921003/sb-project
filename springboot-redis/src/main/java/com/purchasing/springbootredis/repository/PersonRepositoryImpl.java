package com.purchasing.springbootredis.repository;

import com.purchasing.springbootredis.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
@Repository(value = "personRepository")
public class PersonRepositoryImpl implements PersonRepository {

    private Map<Long,Person> repository = new HashMap<>();
    @Override
    public Person selectById(Long id) {
        return repository.get(id);
    }

    @Override
    public boolean save(Person person) {
        return repository.put(person.getId(),person) == null;
    }

    @Override
    public List<Person> selectAll() {
        return (List<Person>) repository.values();
    }
}
