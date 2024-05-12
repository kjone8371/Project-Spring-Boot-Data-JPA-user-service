package com.kjone.kjonespringbootjpaproject.service;

import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.domain.user.SignResponse;

public interface SignService {

    public SignResponse login(SignRequest request) throws Exception;

    public boolean register(SignRequest request) throws Exception;

    public SignResponse getMember(String account) throws Exception;

}
