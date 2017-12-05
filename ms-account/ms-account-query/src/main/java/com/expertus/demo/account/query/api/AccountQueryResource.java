package com.expertus.demo.account.query.api;


import com.expertus.demo.account.domain.Account;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
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

@RestController
@RequestMapping("/api")
public class AccountQueryResource {


    private List<Account> accounts;

    AccountQueryResource() {
        accounts = Lists.newArrayList();
        accounts.add(new Account(1, 1, "1"));
        accounts.add(new Account(2, 2, "2"));
        accounts.add(new Account(3, 3, "3"));
        accounts.add(new Account(4, 4, "4"));
        accounts.add(new Account(5, 1, "5"));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/accounts/{count}")
    Optional<Account> getAccountByCount(@PathVariable("count") String count) {
        return accounts.stream().filter(
                account -> account.getCount().equalsIgnoreCase(count)).findFirst();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/accounts/customer/{customerId}")
    Optional<List<Account>> getAccountByCustomer(@PathVariable("customerId") Integer customerId) {
        List<Account> accountsList = accounts.stream().filter(account -> account.getCustomerId().intValue() == customerId.intValue()).collect(Collectors.toList());
        return CollectionUtils.isEmpty(accountsList) ? Optional.empty() : Optional.of(accountsList);
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/accounts")
    Optional<List<Account>> getAllAccounts() {
        return Optional.of(accounts);
    }


}
