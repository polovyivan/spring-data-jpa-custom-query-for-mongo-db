package com.polovyi.ivan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseAddressEntity {

    @Field(name = "street_address")
    private String streetAddress;

    @Field(name = "street_address_number")
    private String streetAddressNumber;

    private String city;

    @Field(name = "zip_code")
    private String zipCode;

    private String country;

}
