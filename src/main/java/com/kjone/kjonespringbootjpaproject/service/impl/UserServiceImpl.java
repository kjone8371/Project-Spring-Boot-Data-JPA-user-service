package com.kjone.kjonespringbootjpaproject.service.impl;

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
    public UserEntity register(UserEntity user) {
        return null;
    }

    @Override
    public UserEntity login(String id, String password) {
        return null;
    }
}
