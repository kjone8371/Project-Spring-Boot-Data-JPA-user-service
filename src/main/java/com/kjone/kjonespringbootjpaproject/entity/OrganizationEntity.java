package com.kjone.kjonespringbootjpaproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "organization")
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //조직 이름

    @OneToMany(mappedBy = "organization")
    private List<UserEntity> members = new ArrayList<>(); //조직의 구성원 목록

}
