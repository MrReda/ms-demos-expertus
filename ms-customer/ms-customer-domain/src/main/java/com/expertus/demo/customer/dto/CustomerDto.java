package com.expertus.demo.customer.dto;

import com.expertus.demo.account.domain.Account;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {


    private Integer id;
    private String name;
    private Integer age;
    private List<Account> accounts;
}
