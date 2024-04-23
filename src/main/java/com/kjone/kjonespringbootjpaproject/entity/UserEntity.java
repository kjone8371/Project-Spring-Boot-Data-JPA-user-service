package com.kjone.kjonespringbootjpaproject.entity;


import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "user_entity")
public class UserEntity {

    @Id
    private String id; // 사용자 아이디

    private String email; // 구글 이메일

    private String password; // 비밀번호

    private String check_password; // 비밀번호 확인

    private String username; // 유저 이름

    @Column(name = "birth") // DB 테이블 나이 생년월일
    private int age; // 생년월일 나이

    private String createTime; // 회원 생성 날짜

    private Character emailTime; // 이메일 발급 인증 날짜

    @Enumerated(EnumType.STRING)
    private Role role; // 직업 선택

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;  // 사용자가 속한 조직




}

