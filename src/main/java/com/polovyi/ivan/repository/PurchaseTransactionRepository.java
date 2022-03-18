package com.polovyi.ivan.repository;

import com.polovyi.ivan.dto.GetPurchaseTransactionDTO;
import com.polovyi.ivan.entity.PurchaseTransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PurchaseTransactionRepository extends MongoRepository<PurchaseTransactionEntity, String> {
//
    @Query("  {$and: ["
            + "        {$and: ["
            + "                 {'purchasePaymentTransaction.amount': {$gte: :#{#dto.minAmount}} },"
            + "                 {'purchasePaymentTransaction.amount': {$lte: :#{#dto.maxAmount}} } "
            + "                ]"
            + "        },"
            + "        {$or :["
            + "                {$expr: {$eq: [:#{#dto.country}, null]} },"
            + "                {'purchaseTransactionAddress.country': :#{#dto.country} }"
            + "               ]"
            + "         },"
            + "        {$or :["
            + "                {$expr: {$eq: [:#{#dto.paymentType}, []]} },"
            + "                {'purchasePaymentTransaction.paymentType': {'$in': :#{#dto.paymentType}}}"
            + "               ]"
            + "         },"
            + "         {$or :["
            + "                  {"
            + "                   $and: ["
            + "                          {$expr: {$eq: [:#{#dto.getFromDateTime()}, null]}},"
            + "                          {$expr: {$eq: [:#{#dto.getToDateTime()}, null]}}"
            + "                         ]"
            + "                  },"
            + "                  {timestamp : {$gte: :#{#dto.getFromDateTime()}, $lte: :#{#dto.getToDateTime()}}}"
            + "                ]"
            + "         }"
            + "  ]"
            + "}")
    List<PurchaseTransactionEntity> findAllWithFilters(GetPurchaseTransactionDTO dto);

    //                .minAmount(minAmount)+
    //                .maxAmount(maxAmount)+
    //                .date(date)+
    //                .country(country)+
    //                .paymentType(paymentType)
    //                .job(job)
    //
    //
    //
    //                .build());




//    @Query("  {$and: ["
//            + "        {$and: ["
//            + "                 {'purchaseTransactions.amount': {$gte: :#{#dto.minAmount}} },"
//            + "                 {'purchaseTransactions.amount': {$lte: :#{#dto.maxAmount}} } "
//            + "                ]"
//            + "        },"
//            + "        {$or :["
//            + "                {$expr: {$eq: [:#{#dto.date}, null]}},"
//            + "                {'createdAt': :#{#dto.date} }"
//            + "               ]"
//            + "         },"
//            + "        {$or :["
//            + "                {$expr: {$eq: [:#{#dto.country}, null]} },"
//            + "                {'country': :#{#dto.country} }"
//            + "               ]"
//            + "         },"
//            + "        {$or :["
//            + "                {$expr: {$eq: [:#{#dto.job}, null]} },"
//            + "                {'job': :#{#dto.job} }"
//            + "               ]"
//            + "         },"
//            + "        {$or :["
//            + "                {$expr: {$eq: [:#{#dto.paymentType}, []]} },"
//            //            + "                {'purchaseTransactions.paymentType': {'$in': :#{#dto.paymentType}}}"
//            + "                {'purchaseTransactions': {'$elemMatch': { 'paymentType': {'$in': :#{#dto.paymentType}}}}}"
//            + "               ]"
//            + "         }"
//            + "  ]"
//            + "}")




//                + "        {$or :["
//                        + "                {$expr: {$eq: [:#{#dto.date}, null]}},"
//                        + "                {'timestamp': :#{#dto.date} }"
//                        + "               ]"
//                        + "         },"
//                        + "        {$and: ["
//                        + "                {"
//                        + "                  $or :["
//                        + "                         {"
//                        + "                           $and: ["
//                        + "                                  {$expr: {$eq: [:#{#dto.getStartDateTime()}, null]}},"
//                        + "                                  {$expr: {$eq: [:#{#dto.getEndDateTime()}, null]}}"
//                        + "                                 ]"
//                        + "                          }, "
//                        + "                          {"
//                        + "                            "
//                        + "                           }"
//                        + "                         {$expr: {$eq: [:#{#dto.country}, null]} },"
//                        + "                          {'purchaseTransactionAddress.country': :#{#dto.country} }"
//                        + "                },"
//                        + "                {"
//                        + "                  $or :["
//
//                        + "                       ]"
//                        + "                 }"
//                        + "               ]"
//                        + "         },"

}
