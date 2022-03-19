package com.polovyi.ivan.dto;

import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTransactionResponse {

    private String id;

    private LocalDateTime timestamp;

    private PurchaseAddressResponse address;

    private PurchasePaymentTransactionResponse payment;

    private List<PurchaseProductResponse> products;

    public static PurchaseTransactionResponse valueOf(PurchaseTransactionEntity entity) {

        List<PurchaseProductResponse> productResponses = entity.getPurchaseProducts().stream()
                .map(PurchaseProductResponse::valueOf).collect(Collectors.toList());
        return builder()
                .id(entity.getId())
                .timestamp(entity.getTimestamp())
                .address(
                        PurchaseAddressResponse.valueOf(entity.getPurchaseAddress()))
                .payment(
                        PurchasePaymentTransactionResponse.valueOf(entity.getPurchasePayment()))
                .products(productResponses)
                .build();
    }
}
