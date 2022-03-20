package com.polovyi.ivan.repository;

import com.polovyi.ivan.dto.GetPurchaseTransactionDTO;
import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTransactionRepository extends MongoRepository<PurchaseTransactionEntity, String> {

    @Query("  {$and: ["
            + "        {$and: ["
            + "                 {'purchasePayment.amount': {$gte: :#{#dto.minAmount}}},"
            + "                 {'purchasePayment.amount': {$lte: :#{#dto.maxAmount}}} "
            + "               ]"
            + "        },"
            + "        {$or :["
            + "                {$expr: {$eq: [:#{#dto.country}, null]}},"
            + "                {'purchaseAddress.country': :#{#dto.country}}"
            + "               ]"
            + "         },"
            + "        {$or :["
            + "                {$expr: {$eq: [:#{#dto.paymentType}, []]}},"
            + "                {'purchasePayment.paymentType': {'$in': :#{#dto.paymentType}}}"
            + "               ]"
            + "         },"
            + "         {$or :["
            + "                {$expr: {$eq: [:#{#dto.product}, null]}},"
            + "                {'purchaseProducts.name': :#{#dto.product}}"
            + "               ]"
            + "          },"
            + "         {$and: ["
            + "                   {$or: ["
            + "                           {$expr: {$eq: [:#{#dto.getAfterDateTime()}, null]}},"
            + "                           {timestamp : {$gte : :#{#dto.getAfterDateTime()}}}"
            + "                         ]"
            + "                   },"
            + "                   {$or: ["
            + "                           {$expr: {$eq: [:#{#dto.getBeforeDateTime()}, null]}},"
            + "                           {timestamp : {$lte : :#{#dto.getBeforeDateTime()}}}"
            + "                         ]"
            + "                   }"
            + "                ]"
            + "         }"
            + "  ]"
            + "}")
    Page<PurchaseTransactionEntity> findAllWithFilters(GetPurchaseTransactionDTO dto, Pageable pageable);

}
