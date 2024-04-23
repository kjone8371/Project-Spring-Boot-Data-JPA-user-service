package com.kjone.kjonespringbootjpaproject.service.impl;

import com.kjone.kjonespringbootjpaproject.entity.OrganizationEntity;
import com.kjone.kjonespringbootjpaproject.entity.Role;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import com.kjone.kjonespringbootjpaproject.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {


    @Override
    public void assignRoleAndManageOrganization(UserEntity user, Role role) {
        user.setRole(role);
        if (role == Role.OWNER) {
            OrganizationEntity organization = new OrganizationEntity();
            organization.setName(user.getUsername() + "'s Organization");
            organization.getMembers().add(user);
            //조직 저장 로직
            user.setOrganization(organization);
        } else if (role == Role.EMPLOYEE) {
            //조직 찾기 및 조직에 사용자 추가 로직
        }
        //사용자 정보 업데이트
    }

}
