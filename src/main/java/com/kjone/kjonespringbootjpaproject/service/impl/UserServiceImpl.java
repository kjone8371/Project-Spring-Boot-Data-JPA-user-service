package com.kjone.kjonespringbootjpaproject.service.impl;

import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.domain.user.SignResponse;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import com.kjone.kjonespringbootjpaproject.repository.UserRepository;
import com.kjone.kjonespringbootjpaproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public String register(SignRequest request) {
        return null;
    }

    @Override
    public SignResponse login(SignRequest request) {
        return null;
    }
}
