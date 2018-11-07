package com.purchasing.springbootredis.entity;

import java.io.Serializable;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
public class Person implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
