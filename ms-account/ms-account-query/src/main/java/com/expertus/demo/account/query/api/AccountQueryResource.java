package com.expertus.demo.account.query.api;


import com.expertus.demo.account.domain.Account;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

@Slf4j
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

    @ApiOperation("This method retrieves an account by its counter")
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/accounts/{count}")
    ResponseEntity<Account> getAccountByCount(@PathVariable("count") String count) {
        log.info(String.format("Account.getAccountByCount(%s)", count));
        Optional<Account> _account = accounts.stream().filter(
                account -> account.getCount().equalsIgnoreCase(count)).findFirst();
        log.info(String.format("Account.getAccountByCount(%s)", _account));
        return _account.isPresent() ? ResponseEntity.ok(_account.get()) : ResponseEntity.notFound().build();
    }

    @ApiOperation("This method fetches an account by its customer id")
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/accounts/customer/{customerId}")
    ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable("customerId") Integer customerId) {
        log.info(String.format("Account.getAccountsByCustomerId(%s)", customerId));
        List<Account> accountsList = accounts.stream().filter(account -> account.getCustomerId().intValue() == customerId.intValue()).collect(Collectors.toList());
        log.info(String.format("Account.getAccountsByCustomerId(%s)", accountsList));
        return CollectionUtils.isEmpty(accountsList) ? ResponseEntity.notFound().build() : ResponseEntity.ok(accountsList);
    }

    @ApiOperation("Retrieving the list of available accounts")
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/accounts")
    ResponseEntity<List<Account>> getAllAccounts() {
        log.info(String.format("Account.getAllAccounts(%s)", accounts));
        return ResponseEntity.ok(accounts);

    }


}
