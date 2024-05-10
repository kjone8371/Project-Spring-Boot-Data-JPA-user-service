package com.kjone.kjonespringbootjpaproject.entity;


import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
//@Table(name = "organization")
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //조직 이름
    private Role or_roles; // 조직의 권한
    private String createTime; // 조직 생성 날짜
    private String email; // Join 한 조직 이메일

//    @OneToMany(mappedBy = "organization")
//    private List<UserEntity> members = new ArrayList<>(); //조직의 구성원 목록

}
