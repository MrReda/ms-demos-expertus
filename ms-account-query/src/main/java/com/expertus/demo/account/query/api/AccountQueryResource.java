package com.expertus.demo.account.query.api;


import com.expertus.demo.account.domain.Account;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountQueryResource {


    private List<Account> accounts = Lists.newArrayList();


}
