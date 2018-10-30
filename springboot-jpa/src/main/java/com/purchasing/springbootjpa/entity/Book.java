package com.purchasing.springbootjpa.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * @author Administrator
 * @createTime 2018/10/30
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String isbn;

    private Date publishDate;

    @ManyToMany(mappedBy = "books")
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
