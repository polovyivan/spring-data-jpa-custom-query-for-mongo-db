package com.polovyi.ivan.dto;

import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTransactionResponse {

    private String id;

    private LocalDateTime timestamp;

    private PurchaseTransactionAddressResponse purchaseTransactionAddress;

    private PurchasePaymentTransactionResponse purchasePaymentTransaction;

    public static PurchaseTransactionResponse valueOf(PurchaseTransactionEntity entity) {
        return builder()
                .id(entity.getId())
                .timestamp(entity.getTimestamp())
                .purchaseTransactionAddress(
                        PurchaseTransactionAddressResponse.valueOf(entity.getPurchaseTransactionAddress()))
                .purchasePaymentTransaction(
                        PurchasePaymentTransactionResponse.valueOf(entity.getPurchasePaymentTransaction()))
                .build();
    }
}
