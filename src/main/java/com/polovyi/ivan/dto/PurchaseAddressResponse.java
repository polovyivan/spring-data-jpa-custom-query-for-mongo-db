package com.polovyi.ivan.dto;

import com.polovyi.ivan.entity.PurchaseAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseAddressResponse {
    private String streetAddress;

    private String streetAddressNumber;

    private String city;

    private String zipCode;

    private String country;

    public static PurchaseAddressResponse valueOf(PurchaseAddressEntity entity){
        return builder()
                .streetAddress(entity.getStreetAddress())
                .streetAddressNumber(entity.getStreetAddressNumber())
                .city(entity.getCity())
                .zipCode(entity.getZipCode())
                .country(entity.getCountry())
                .build();
    }
}
