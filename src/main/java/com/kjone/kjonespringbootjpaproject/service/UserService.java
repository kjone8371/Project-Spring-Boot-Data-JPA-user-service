package com.kjone.kjonespringbootjpaproject.service;

import com.kjone.kjonespringbootjpaproject.entity.UserEntity;

public interface UserService {
    public UserEntity register(UserEntity user);

    public UserEntity login(String id, String password);
}
