package com.polovyi.ivan.dto;

import com.polovyi.ivan.entity.PurchasePaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchasePaymentTransactionResponse {

    private String paymentType;

    private BigDecimal amount;


    public static PurchasePaymentTransactionResponse valueOf(PurchasePaymentEntity entity){
        return builder()
                .paymentType(entity.getPaymentType())
                .amount(entity.getAmount())
                .build();
    }
}
