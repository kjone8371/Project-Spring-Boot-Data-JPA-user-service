package com.kjone.kjonespringbootjpaproject.domain.organization;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RequestOrg {

    private Long id;
    private String name; //조직 이름
//    private Role or_roles; // 조직의 권한
//    private String createTime; // 조직 생성 날짜
//    private String email; // Join 한 조직 이메

//    @OneToMany(mappedBy = "organization")
//    private List<UserEntity> members = new ArrayList<>(); //조직의 구성원 목록
}
