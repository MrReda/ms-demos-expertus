package com.expertus.demo.customer.domain;

import com.expertus.demo.account.domain.Account;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Customer {

    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    private List<Account> accounts;


}
