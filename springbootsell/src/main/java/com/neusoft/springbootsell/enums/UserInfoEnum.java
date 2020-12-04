package com.neusoft.springbootsell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserInfoEnum implements CodeEnum {
    BUYER(0,"买家"),
    SELLER(1,"商家"),
    ;
    private Integer code;
    private String message;
}
