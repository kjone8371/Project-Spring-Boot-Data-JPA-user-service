package com.kjone.kjonespringbootjpaproject.domain.user;


import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {
    private Long id;
    private String email;
    private String password;
    private String check_password;
    private String username;
    private int age;
    private Role role;
}
