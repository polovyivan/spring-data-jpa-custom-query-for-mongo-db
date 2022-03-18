package com.polovyi.ivan.service;

import com.polovyi.ivan.dto.GetPurchaseTransactionDTO;
import com.polovyi.ivan.dto.PurchaseTransactionResponse;
import com.polovyi.ivan.repository.PurchaseTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public record CustomerService(PurchaseTransactionRepository purchaseTransactionRepository) {

    public List<PurchaseTransactionResponse> getAllCustomers(GetPurchaseTransactionDTO dto) {
        log.info("Getting all customers with filters {}...", dto);
//        return purchaseTransactionRepository.findAll().stream().map(PurchaseTransactionResponse::valueOf).collect(Collectors.toList());
        return purchaseTransactionRepository.findAllWithFilters(dto).stream().map(PurchaseTransactionResponse::valueOf).collect(Collectors.toList());
    }
}
