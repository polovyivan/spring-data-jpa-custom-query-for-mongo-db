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

    private PurchaseTransactionAddressResponse purchaseTransactionAddress;

    private PurchasePaymentTransactionResponse purchasePaymentTransaction;

    private List<PurchaseProductResponse> purchaseProductEntities;

    public static PurchaseTransactionResponse valueOf(PurchaseTransactionEntity entity) {

        List<PurchaseProductResponse> productResponses = entity.getPurchaseTransactionProducts().stream()
                .map(PurchaseProductResponse::valueOf).collect(Collectors.toList());
        return builder()
                .id(entity.getId())
                .timestamp(entity.getTimestamp())
                .purchaseTransactionAddress(
                        PurchaseTransactionAddressResponse.valueOf(entity.getPurchaseTransactionAddress()))
                .purchasePaymentTransaction(
                        PurchasePaymentTransactionResponse.valueOf(entity.getPurchasePaymentTransaction()))
                .purchaseProductEntities(productResponses)
                .build();
    }
}
