package com.expertus.demo.customer.query.service;

import com.expertus.demo.account.domain.Account;
import com.expertus.demo.customer.query.feign.AccountQueryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class AccountRemoteService {

    private AccountQueryClient accountQueryClient;

    public Optional<List<Account>> getAccountByCustomer(@PathVariable("customerId") Integer customerId) {
        return accountQueryClient.getAccountByCustomer(customerId);
    }


}
