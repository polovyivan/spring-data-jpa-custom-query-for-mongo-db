package com.polovyi.ivan.controller;

import com.polovyi.ivan.dto.GetPurchaseTransactionDTO;
import com.polovyi.ivan.dto.PurchaseTransactionResponse;
import com.polovyi.ivan.service.CustomerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
public record CustomerController(CustomerService customerService) {

    @GetMapping(path = "/v1/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseTransactionResponse> getAllCustomers(
            @RequestParam BigDecimal minAmount,
            @RequestParam BigDecimal maxAmount,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,
            @RequestParam(required = false, defaultValue = "#{new java.util.HashSet()}") Set<String> paymentType) {
        return customerService.getAllCustomers(GetPurchaseTransactionDTO.builder()
                .country(country)
                .paymentType(paymentType)
                .minAmount(minAmount)
                .maxAmount(maxAmount)
                .fromDate(fromDate)
                .toDate(toDate)
                .build());
    }

}
