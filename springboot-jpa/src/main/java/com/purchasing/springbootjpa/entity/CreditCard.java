package com.purchasing.springbootjpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Administrator
 * @createTime 2018/10/30
 */
@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    @Column(name = "create_date")
    private Date createDate;

    @OneToOne(mappedBy = "creditCard")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
