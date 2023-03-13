package com.example.account.exception;

import com.example.account.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountException extends RuntimeException {
    private ErrorCode errorCode;
    private String errorMassage;

    // 생성자
    public AccountException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMassage = errorCode.getDescription();
    }
}
