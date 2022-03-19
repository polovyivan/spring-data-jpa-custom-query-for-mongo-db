package com.polovyi.ivan.service;

import com.polovyi.ivan.dto.GetPurchaseTransactionDTO;
import com.polovyi.ivan.dto.PurchaseTransactionResponse;
import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import com.polovyi.ivan.repository.PurchaseTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public record CustomerService(PurchaseTransactionRepository purchaseTransactionRepository) {

    public Page <PurchaseTransactionResponse> getAllCustomers(GetPurchaseTransactionDTO dto) {
        log.info("Getting all customers with filters {}...", dto);
        Sort sort = Sort.by(Sort.Direction.ASC, "timestamp");
        Pageable page = PageRequest.of(dto.getPage(), dto.getSize(), sort);

        Page<PurchaseTransactionEntity> purchaseTransactionEntities = purchaseTransactionRepository.findAllWithFilters(dto, page);

        List<PurchaseTransactionResponse> purchaseTransactionResponses = purchaseTransactionEntities.stream()
                .map(PurchaseTransactionResponse::valueOf)
                .collect(Collectors.toList());
        return PageableExecutionUtils.getPage(purchaseTransactionResponses, page, purchaseTransactionEntities::getTotalElements);
    }
}
