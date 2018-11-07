package com.purchasing.springbootredis.repository.redis;

import com.purchasing.springbootredis.entity.Person;
import com.purchasing.springbootredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
@Repository(value = "redisRepository")
public class PersonRedisRepositoryImpl implements PersonRepository {

   @Autowired
   private RedisTemplate redisTemplate;

    @Override
    public Person selectById(Long id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean save(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
        return true;
    }

    @Override
    public List<Person> selectAll() {
        List<Long> keys = new ArrayList<>();
        keys.add(1l);
        keys.add(2l);
        keys.add(3l);
        return (List<Person>) redisTemplate.opsForValue().multiGet(keys);
    }
}
