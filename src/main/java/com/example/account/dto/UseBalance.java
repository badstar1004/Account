package com.example.account.dto;

import com.example.account.aop.AccountLockIdInterface;
import com.example.account.type.TransactionResultType;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UseBalance {
    /***
     * {
     *      "userId":1,
     *      "accountNumber":"1000000000",
     *      "amount":1000
     * }
     */
    // inner class
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {

        @NotNull
        @Min(1)
        private Long userId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;

    }

    /***
     * {
     *      "accountNumber":"1234567890",
     *      "transactionResult":"S",
     *      "transactionId":"c2033bb6d82a4250aecf8e27c49b63f6",
     *      "amount":1000,
     *      "transactedAt":"2022-06-01T23:26:14.671859"
     * }
     */
    // inner class
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private String accountNumber;
        private TransactionResultType transactionResultType;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;

        public static Response from(TransactionDto transactionDto) {
            return Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResultType(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }
    }
}
