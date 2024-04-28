package com.kjone.kjonespringbootjpaproject.service.impl;

import com.kjone.kjonespringbootjpaproject.entity.OrganizationEntity;
import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import com.kjone.kjonespringbootjpaproject.repository.OrganizationRepository;
import com.kjone.kjonespringbootjpaproject.repository.UserRepository;
import com.kjone.kjonespringbootjpaproject.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {


    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;

    @Override
    public void createOrganization(UserEntity user, Role role) {
        user.setRole(role);
        if (role == Role.OWNER) {
            OrganizationEntity organization = new OrganizationEntity();
            organization.setName(user.getUsername() + "'s Organization");
            organization.setEmail(user.getEmail());  // 조직 이메일 설정
            organization.setCreateTime(java.time.LocalDate.now().toString()); // 현재 날짜를 생성 날짜로 설정
            organization.getMembers().add(user);
            organizationRepository.save(organization); // 조직 저장
            user.setOrganization(organization); // 사용자에게 조직 할당
            userRepository.save(user); // 변경된 사용자 정보 저장
        } else if (role == Role.EMPLOYEE) {
            // EMPLOYEE의 경우 추가 로직 필요 (예: 특정 조직에 할당)
        }
        // 사용자 정보 업데이트
        organizationRepository.save(user);
    }

//    public List<UserEntity> findAllEmployeesInOrganization(Long organizationId) {
//        OrganizationEntity organization = organizationRepository.findById(organizationId)
//                .orElseThrow(() -> new RuntimeException("Organization not found"));
//        return organization.getMembers(); // 해당 조직의 모든 멤버 반환
//    }

}
