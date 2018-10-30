package com.purchasing.springbootjpa.controller;

import com.purchasing.springbootjpa.entity.Customer;
import com.purchasing.springbootjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @createTime 2018/10/30
 */
@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
}
