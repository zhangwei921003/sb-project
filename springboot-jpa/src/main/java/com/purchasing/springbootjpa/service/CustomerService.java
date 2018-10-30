package com.purchasing.springbootjpa.service;

import com.purchasing.springbootjpa.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Administrator
 * @createTime 2018/10/30
 */
@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Customer save(Customer customer){
        if(StringUtils.isEmpty(customer.getId())){
            entityManager.persist(customer);
            return customer;
        }else {
            return entityManager.merge(customer);
        }
    }
}
