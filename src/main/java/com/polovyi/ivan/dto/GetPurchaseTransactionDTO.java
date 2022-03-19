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

    private LocalDate before;

    private LocalDate after;

    private String country;

    private Set<String> paymentType;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;

    private int page;

    private int size;

    public LocalDateTime getAfterDateTime() {
        return Optional.ofNullable(this.before)
                .map(toDate -> toDate.atTime(LocalTime.MIN))
                .orElse(null);
    }

    public LocalDateTime getBeforeDateTime() {
        return Optional.ofNullable(this.after)
                .map(toDate -> toDate.atTime(LocalTime.MAX))
                .orElse(null);
    }
}
