package com.polovyi.ivan.dto;

import com.polovyi.ivan.entity.PurchaseProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProductResponse {

    private String name;

    private BigDecimal price;

    public static PurchaseProductResponse valueOf(PurchaseProductEntity entity) {
        return builder()
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }
}
