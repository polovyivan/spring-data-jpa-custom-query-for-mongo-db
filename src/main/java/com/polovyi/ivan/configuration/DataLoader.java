package com.polovyi.ivan.configuration;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.polovyi.ivan.entity.PurchasePaymentEntity;
import com.polovyi.ivan.entity.PurchaseProductEntity;
import com.polovyi.ivan.entity.PurchaseAddressEntity;
import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import com.polovyi.ivan.repository.PurchaseTransactionRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Component
public record DataLoader(PurchaseTransactionRepository purchaseTransactionRepository) {

    @Bean
    private InitializingBean sendDatabase() {
        Faker faker = new Faker();
        return () -> {
            purchaseTransactionRepository.saveAll(generateCustomerList(faker));
        };
    }

    private List<PurchaseTransactionEntity> generateCustomerList(Faker faker) {
        return IntStream.range(0, 50)
                .mapToObj(i -> {
                    List<PurchaseProductEntity> purchaseProductEntities = generatePurchaseProductList(faker);
                    BigDecimal totalAmount = purchaseProductEntities.stream().map(PurchaseProductEntity::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    return PurchaseTransactionEntity.builder()
                            .id(UUID.randomUUID().toString())
                            .timestamp(LocalDateTime.now().minus(Period.ofDays((new Random().nextInt(365 * 10)))))
                            .purchaseAddress(PurchaseAddressEntity.builder()
                                    .streetAddress(faker.address().streetAddress())
                                    .streetAddressNumber(faker.address().streetAddressNumber())
                                    .city(faker.address().city())
                                    .zipCode(faker.address().zipCode())
                                    .country(faker.address().country())
                                    .build())
                            .purchasePayment(PurchasePaymentEntity.builder()
                                    .amount(totalAmount)
                                    .paymentType(List.of(CreditCardType.values())
                                            .get(new Random().nextInt(CreditCardType.values().length)).toString())
                                    .build())
                            .purchaseProducts(purchaseProductEntities)
                            .build();

                })
                .collect(toList());
    }

    private List<PurchaseProductEntity> generatePurchaseProductList(Faker faker) {
        return IntStream.range(0, new Random().nextInt(4 - 1 + 1) + 1)
                .mapToObj(i -> PurchaseProductEntity.builder()
                        .name(faker.commerce().productName())
                        .price(new BigDecimal(faker.commerce().price().replaceAll(",", ".")))
                        .build())
                .collect(toList());
    }
}
