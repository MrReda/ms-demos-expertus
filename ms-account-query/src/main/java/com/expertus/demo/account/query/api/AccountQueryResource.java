package com.expertus.demo.account.query.api;


import com.expertus.demo.account.domain.Account;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/account/{count}")
    Optional<Account> findByCount(@PathVariable("count") String count) {
        return accounts.stream().filter(
                account -> account.getCount().equalsIgnoreCase(count)).findFirst();
    }

}
