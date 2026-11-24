package com.example.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SecurityConfig {
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())
                .formLogin(withDefaults());

        return http.build();
    }
}
