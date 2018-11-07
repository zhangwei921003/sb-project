package com.purchasing.springbootredis.repository;

import com.purchasing.springbootredis.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person selectById(Long id);

    boolean save(Person person);

    List<Person> selectAll();
}
