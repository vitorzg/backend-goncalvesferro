package com.api.goncalvesrep.orcamentos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                        .csrf(csrf -> csrf.disable())
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authorizeHttpRequests(authorize -> authorize
                                                                    // .requestMatchers(HttpMethod.POST, "auth/login").permitAll()
                                                                    // .requestMatchers(HttpMethod.POST, "auth/register").hasRole("ADMIN")
                                                                    // .requestMatchers(HttpMethod.GET, "user/all").hasRole("ADMIN")
                                                                    // .requestMatchers(HttpMethod.GET, "user/details/{id}").hasRole("ADMIN")
                                                                    // .requestMatchers(HttpMethod.PUT, "user/{id}").hasRole("ADMIN")
                                                                    // .requestMatchers(HttpMethod.DELETE, "user/{id}").hasRole("ADMIN")
                                                                    .anyRequest().permitAll()
                                                                    )
                                                                .addFilterBefore(securityFilter,UsernamePasswordAuthenticationFilter.class)
                                                                .build();

    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
