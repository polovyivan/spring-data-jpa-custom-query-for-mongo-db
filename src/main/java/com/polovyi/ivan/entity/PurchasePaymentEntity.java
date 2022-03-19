package com.polovyi.ivan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchasePaymentEntity {

    @Field(name = "payment_type")
    private String paymentType;

    @Field(targetType = DECIMAL128)
    private BigDecimal amount;
}
