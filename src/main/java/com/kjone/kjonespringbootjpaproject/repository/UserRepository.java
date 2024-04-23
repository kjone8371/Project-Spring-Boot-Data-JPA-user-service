package com.kjone.kjonespringbootjpaproject.repository;

import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
