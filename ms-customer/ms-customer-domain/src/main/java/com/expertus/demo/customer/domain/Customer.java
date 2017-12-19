package com.expertus.demo.customer.domain;

import com.expertus.demo.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private Integer age;
    private List<Account> accounts;


}
