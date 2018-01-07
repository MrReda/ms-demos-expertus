package com.expertus.demo.customer.query.feign;


import com.expertus.demo.account.domain.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("account-service")
public interface AccountQueryClient {

    @RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "/api/v1/accounts/customer/{customerId}")
    List<Account> getAccountsByCustomerId(@PathVariable("customerId") Integer customerId);


}
