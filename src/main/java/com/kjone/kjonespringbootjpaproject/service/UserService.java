package com.kjone.kjonespringbootjpaproject.service;

import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.domain.user.SignResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService extends UserDetailsService {
    public boolean register(SignRequest request) throws Exception;

    public SignResponse login(SignRequest request) throws Exception;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
