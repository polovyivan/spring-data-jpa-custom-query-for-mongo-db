package com.polovyi.ivan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPurchaseTransactionDTO {

    private LocalDate fromDate;

    private LocalDate toDate;

    private String country;

    private Set<String> paymentType;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;

    public LocalDateTime getFromDateTime() {
        return Optional.ofNullable(this.fromDate)
                .map(toDate -> toDate.atTime(LocalTime.MIN))
                .orElse(null);
    }

    public LocalDateTime getToDateTime() {
        return Optional.ofNullable(this.toDate)
                .map(toDate -> toDate.atTime(LocalTime.MAX))
                .orElse(null);
    }
}
