package com.kjone.kjonespringbootjpaproject.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public enum Role {
    USER, // 회원
    OWNER,  // 사장
    EMPLOYEE  // 직원
}
