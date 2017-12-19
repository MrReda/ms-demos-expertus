package com.expertus.demo.customer.query.Api;


import com.expertus.demo.account.domain.Account;
import com.expertus.demo.customer.domain.Customer;
import com.expertus.demo.customer.query.feign.AccountQueryClient;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    AccountQueryClient accountQueryClient;

    private List<Customer> customers;

    public CustomerQueryResource() {
        customers = Lists.newArrayList();
        customers.add(new Customer(1, "MrReda", 30, null));
        customers.add(new Customer(2, "Jonathan", 25, null));
        customers.add(new Customer(3, "Alex", 36, null));
        customers.add(new Customer(4, "Richard", 42, null));
        customers.add(new Customer(5, "Amanda", 33, null));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers/{name}/name")
    ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name) {
        Optional<Customer> _customer = customers.stream().filter(customer -> customer.getName().equalsIgnoreCase(name)).findFirst();
        return _customer.isPresent() ? ResponseEntity.ok(_customer.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers")
    ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customers.stream().filter(_customer -> _customer.getId().intValue() == id).findFirst();
        Optional<List<Account>> accountList = Optional.ofNullable(accountQueryClient.getAccountByCustomer(id));
        customer.ifPresent(_customer -> _customer.setAccounts(accountList.orElse(Lists.newArrayList())));
        return customer.isPresent() ? ResponseEntity.ok(customer.get()) : ResponseEntity.notFound().build();
    }

}
