package com.polovyi.ivan.dto;

import com.polovyi.ivan.entity.PurchaseTransactionAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTransactionAddressResponse {
    private String streetAddress;

    private String streetAddressNumber;

    private String city;

    private String zipCode;

    private String country;

    public static PurchaseTransactionAddressResponse valueOf(PurchaseTransactionAddressEntity entity){
        return builder()
                .streetAddress(entity.getStreetAddress())
                .streetAddressNumber(entity.getStreetAddressNumber())
                .city(entity.getCity())
                .zipCode(entity.getZipCode())
                .country(entity.getCountry())
                .build();
    }
}
