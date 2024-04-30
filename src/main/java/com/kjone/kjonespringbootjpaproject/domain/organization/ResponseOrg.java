package com.kjone.kjonespringbootjpaproject.domain.organization;

import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import com.kjone.kjonespringbootjpaproject.entity.OrganizationEntity;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import jakarta.persistence.OneToMany;
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
public class ResponseOrg {
    private Long id;
    private String name; //조직 이름
//    private Role or_roles; // 조직의 권한
//    private String createTime; // 조직 생성 날짜
//    private String email; // Join 한 조직 이메

//    @OneToMany(mappedBy = "organization")
//    private List<UserEntity> members = new ArrayList<>(); //조직의 구성원 목록

    public ResponseOrg(OrganizationEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
    
}
