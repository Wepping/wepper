package com.wepping.wepper.config

import com.wepping.wepper.config.filter.ExceptionFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http.cors { cors -> cors.disable() }
            .csrf { csrf -> csrf.disable() }
            .sessionManagement { sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .addFilterBefore(ExceptionFilter.create(), BasicAuthenticationFilter::class.java)
            .authorizeHttpRequests { auth -> auth.anyRequest().permitAll() }
            .build()
    }
}