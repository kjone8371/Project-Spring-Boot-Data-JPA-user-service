package com.kjone.kjonespringbootjpaproject.domain;


import com.kjone.kjonespringbootjpaproject.entity.OrganizationEntity;
import com.kjone.kjonespringbootjpaproject.entity.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String password;
    private String check_password;
    private String username;
    @Column(name = "birth")
    private int age;
    private Character emailTime;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;

}
