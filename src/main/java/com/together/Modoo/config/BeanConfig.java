package com.together.Modoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 빈 설정 항목은 이쪽으로 배치
 */
@Configuration
public class BeanConfig {

    /**
     * 비밀번호 암호 인코더 설정
     * @return PasswordEncoder Impl
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
