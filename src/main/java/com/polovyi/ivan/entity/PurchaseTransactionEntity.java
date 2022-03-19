package com.polovyi.ivan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("purchase_transaction")
public class PurchaseTransactionEntity {

    private String id;

    @Field(targetType = FieldType.DATE_TIME)
    private LocalDateTime timestamp;

    @Field(name = "purchase_address")
    private PurchaseAddressEntity purchaseAddress;

    @Field(name = "purchase_payment")
    private PurchasePaymentEntity purchasePayment;

    @Field(name = "purchase_products")
    private List<PurchaseProductEntity> purchaseProducts;

}
