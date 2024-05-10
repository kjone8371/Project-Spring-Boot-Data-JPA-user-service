package com.kjone.kjonespringbootjpaproject.repository;

import com.kjone.kjonespringbootjpaproject.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {


    Optional<OrganizationEntity> addOrganization(OrganizationEntity organizationEntity);

    Optional<OrganizationEntity> findByName(String name);


}
