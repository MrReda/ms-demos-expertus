package com.expertus.demo.customer.query.Api;


import com.expertus.demo.customer.domain.Customer;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Api {

    private List<Customer> customers;

   public Api(){
       customers = Lists.newArrayList();
        customers.add(new Customer(1,"MrReda",30));
       customers.add(new Customer(2,"Jonathan",25));
       customers.add(new Customer(3,"Alex",36));
       customers.add(new Customer(4,"Richard",42));
       customers.add(new Customer(5,"Amanda",33));
    }


}
