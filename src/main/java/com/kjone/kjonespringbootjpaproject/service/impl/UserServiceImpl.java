package com.kjone.kjonespringbootjpaproject.service.impl;

import com.kjone.kjonespringbootjpaproject.JwtProvider;
import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.domain.user.SignResponse;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import com.kjone.kjonespringbootjpaproject.repository.UserRepository;
import com.kjone.kjonespringbootjpaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Lazy
    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public boolean register(SignRequest request) throws Exception{

        //이메일 중복 검사
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return false; //이미 존재하는 이메일이면 return값을 false값으로 반환 해줌.
        }
        if (!request.getPassword().equals(request.getCheck_password())) {
            throw new Exception("비밀번호 확인이 일치하지 않습니다.");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new Exception("이 이메일은 이미 사용 중입니다.");
        }


        UserEntity entity = UserEntity.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .check_password(passwordEncoder.encode(request.getCheck_password()))
                    .username(request.getUsername())
                    .age(request.getAge())
                    .role(request.getRole())
                    .build();
            userRepository.save(entity);  // 사용자 저장

        return true; //성공적으로 등록됨.
    }

    @Override
    public SignResponse login(SignRequest request) throws Exception{
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new Exception("Login failed: User not found."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new Exception("Login failed: Incorrect password.");
        }

        String token = jwtProvider.createToken(user.getEmail(), user.getRole());


        return new SignResponse(user, token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found: " + username)
        );
        return new User(
                user.getUsername(),
                user.getPassword(),
                true, // isAccountNonExpired
                true, // isAccountNonLocked
                true, // isCredentialsNonExpired
                true, // isEnabled
                Collections.singletonList(new SimpleGrantedAuthority("USER")) // 기본 권한 할당
        );
    }


}
