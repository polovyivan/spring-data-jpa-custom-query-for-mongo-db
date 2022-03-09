package com.polovyi.ivan.service;

import com.polovyi.ivan.dto.CustomerResponse;
import com.polovyi.ivan.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository) {

    public List<CustomerResponse> getAllCustomers() {
        log.info("Getting all customers...");
        return customerRepository.findAll().stream().map(CustomerResponse::valueOf).collect(Collectors.toList());
    }

    public List<CustomerResponse> getAllCustomersByPaymentType(String paymentType) {
        log.info("Getting all customers by payment type {} ...", paymentType);
        return customerRepository.findAll().stream().map(CustomerResponse::valueOf).collect(Collectors.toList());
    }
}
