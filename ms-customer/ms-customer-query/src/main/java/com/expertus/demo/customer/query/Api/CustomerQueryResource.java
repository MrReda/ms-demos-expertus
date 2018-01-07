package com.expertus.demo.customer.query.Api;


import com.expertus.demo.account.domain.Account;
import com.expertus.demo.common.ms.Try;
import com.expertus.demo.customer.domain.Customer;
import com.expertus.demo.customer.query.feign.AccountQueryClient;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author reda
 */
@Slf4j
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

    @ApiOperation("This method retrieves a customer by its name")
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers/{name}/name")
    ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name) {
        log.info(String.format("Customer.getCustomerByName(%s)", name));
        Optional<Customer> _customer = customers.stream().filter(customer -> customer.getName().equalsIgnoreCase(name))
                .map(customerAccounts -> fetchCustomerAccounts(customerAccounts)).findFirst();
        log.info(String.format("Customer.getCustomerByName(%s)", _customer));
        return _customer.isPresent() ? ResponseEntity.ok(_customer.get()) : ResponseEntity.notFound().build();
    }

    @ApiOperation("This method retrieves all customers")
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers")
    ResponseEntity<List<Customer>> getCustomers() {
        customers.stream().map(this::fetchCustomerAccounts).collect(Collectors.toList());
        log.info(String.format("Customer.getCustomers(%s)", customers));
        return ResponseEntity.ok(customers);
    }

    @ApiOperation("This method fetches a customer by its identifier")
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/customers/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        log.info(String.format("Customer.getCustomerById(%s)", id));
        Optional<Customer> customer = customers.stream().filter(_customer -> _customer.getId().intValue() == id)
                .map(this::fetchCustomerAccounts)
                .findFirst();
        log.info(String.format("Customer.getCustomerById(%s)", id));
        return customer.isPresent() ? ResponseEntity.ok(customer.get()) : ResponseEntity.notFound().build();
    }

    public Customer fetchCustomerAccounts(Customer customer) {
        Try<List<Account>> accounts = Try.of(() -> accountQueryClient.getAccountsByCustomerId(customer.getId()));
        customer.setAccounts(accounts.orElse(null));
        return customer;
    }
}
