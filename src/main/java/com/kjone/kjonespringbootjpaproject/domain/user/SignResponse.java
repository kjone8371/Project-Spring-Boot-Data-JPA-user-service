package com.kjone.kjonespringbootjpaproject.domain.user;


import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignResponse {
    private Long id;
    private String email;
    private String password;
    private String check_password;
    private String username;
    private int age;
    private Role role;
    private List<Role> roles = new ArrayList<>();
    private String token;

    public SignResponse(UserEntity user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.check_password = user.getCheck_password();
        this.username = user.getUsername();
        this.age = user.getAge();
        this.role = user.getRole();
    }

}
