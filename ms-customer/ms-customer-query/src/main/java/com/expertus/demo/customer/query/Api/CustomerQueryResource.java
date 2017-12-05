package com.expertus.demo.customer.query.Api;


import com.expertus.demo.customer.domain.Customer;
import com.expertus.demo.customer.query.service.AccountRemoteService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author reda
 */

@RestController
@RequestMapping("/api")
public class CustomerQueryResource {

    @Autowired
    AccountRemoteService accountRemoteService;
    private List<Customer> customers;

    public CustomerQueryResource() {
        customers = Lists.newArrayList();
        customers.add(new Customer(1, "MrReda", 30));
        customers.add(new Customer(2, "Jonathan", 25));
        customers.add(new Customer(3, "Alex", 36));
        customers.add(new Customer(4, "Richard", 42));
        customers.add(new Customer(5, "Amanda", 33));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers/{name}")
    Optional<Customer> getCustomerByName(@PathVariable("name") String name) {
        return customers.stream().filter(customer -> customer.getName().equalsIgnoreCase(name)).findFirst();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers")
    Optional<List<Customer>> getCustomers() {
        return Optional.of(customers);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers/{id}")
    Optional<Customer> getCustomerById(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customers.stream().filter(_customer -> _customer.getId().intValue() == id).findFirst();
        customer.get().setAccounts(accountRemoteService.getAccountByCustomer(id).get());
        return customer;
    }

}
