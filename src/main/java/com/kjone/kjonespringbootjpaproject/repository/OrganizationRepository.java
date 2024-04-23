package com.kjone.kjonespringbootjpaproject.repository;

import com.kjone.kjonespringbootjpaproject.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
