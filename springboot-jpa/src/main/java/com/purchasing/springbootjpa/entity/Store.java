package com.purchasing.springbootjpa.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Administrator
 * @createTime 2018/10/30
 */
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "store")
    private Collection<Customer> customers;

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

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

}
