package com.kjone.kjonespringbootjpaproject.service;


import com.kjone.kjonespringbootjpaproject.entity.Role;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;

public interface OrganizationService {
    public void assignRoleAndManageOrganization(UserEntity user, Role role);
}
