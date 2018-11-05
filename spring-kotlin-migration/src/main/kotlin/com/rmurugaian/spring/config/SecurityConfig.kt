package com.rmurugaian.spring.config

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

/**
 * @author rmurugaian 2018-10-26
 */
@Configuration
class SecurityConfig {

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {

        return http
                    .authorizeExchange()
                        .matchers(EndpointRequest.toAnyEndpoint()).authenticated()
                        .anyExchange().permitAll().and()
                    .formLogin().and()
                    .httpBasic().and()
              .build()
    }

}