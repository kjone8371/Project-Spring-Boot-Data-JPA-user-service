package com.kjone.kjonespringbootjpaproject.repository;

import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
    Optional<SignRequest> findByRequestedId(String id);

}
