package com.expertus.demo.customer.query.feign;


import com.expertus.demo.account.domain.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api")
public interface AccountQueryClient {

    @RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "/v1/accounts/customer/{customerId}")
    Optional<List<Account>> getAccountByCustomer(@PathVariable("customerId") Integer customerId);


}
