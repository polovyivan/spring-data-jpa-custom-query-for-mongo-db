package com.polovyi.ivan.controller;

import com.polovyi.ivan.dto.GetPurchaseTransactionDTO;
import com.polovyi.ivan.dto.PurchaseTransactionResponse;
import com.polovyi.ivan.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate after,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate before,
            @RequestParam(required = false, defaultValue = "#{new java.util.HashSet()}") Set<String> paymentType,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            HttpServletResponse response) {
        Page<PurchaseTransactionResponse> allCustomers = customerService.getAllCustomers(
                GetPurchaseTransactionDTO.builder()
                        .country(country)
                        .paymentType(paymentType)
                        .minAmount(minAmount)
                        .maxAmount(maxAmount)
                        .before(after)
                        .after(before)
                        .page(page)
                        .size(size)
                        .build());
        response.setHeader("total-pages", String.valueOf(allCustomers.getTotalPages()));
        return allCustomers.getContent();
    }

}
