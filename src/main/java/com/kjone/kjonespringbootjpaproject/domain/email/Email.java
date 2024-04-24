package com.kjone.kjonespringbootjpaproject.domain.email;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Email {
    private String email;
    private String password;
}
