package com.tom.entity;

import com.tom.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tom on 2016/5/1.
 */
public  interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}