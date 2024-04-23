package com.kjone.kjonespringbootjpaproject.service;

import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.domain.user.SignResponse;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;

public interface UserService {
    public String register(SignRequest request);

    public SignResponse login(SignRequest request);
}
