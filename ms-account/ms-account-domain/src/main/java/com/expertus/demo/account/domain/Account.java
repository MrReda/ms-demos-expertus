package com.expertus.demo.account.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private Integer id;
    private Integer customerId;
    private String count;


}
