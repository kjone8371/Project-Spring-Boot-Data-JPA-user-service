package com.kjone.kjonespringbootjpaproject.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").authenticated()
                        .anyRequest().permitAll()
                );
        http
                .formLogin(form -> form
                        .loginPage("/login")                 // 사용자 정의 로그인 페이지
                        .loginProcessingUrl("/api/login")    // 로그인 폼 액션 URL
                        .defaultSuccessUrl("/", true)        // 로그인 성공 후 리다이렉트할 기본 URL
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // 로그아웃 처리 URL
                )
                .csrf(AbstractHttpConfigurer::disable);           // CSRF 보호 비활성화

        return http.build();
    }

}
