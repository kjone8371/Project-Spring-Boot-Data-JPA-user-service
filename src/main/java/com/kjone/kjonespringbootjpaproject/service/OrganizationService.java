package com.kjone.kjonespringbootjpaproject.service;


import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;

import java.util.List;

public interface OrganizationService {
    public void createOrganization(UserEntity user, Role role);
}
