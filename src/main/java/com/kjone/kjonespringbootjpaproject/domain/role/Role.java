package com.kjone.kjonespringbootjpaproject.domain.role;


import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Role {
    USER, // 회원
    OWNER,  // 사장
    EMPLOYEE  // 직원
}
