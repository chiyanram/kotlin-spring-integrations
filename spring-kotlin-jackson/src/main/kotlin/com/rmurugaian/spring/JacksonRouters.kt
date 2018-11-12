package com.rmurugaian.spring

import com.rmurugaian.spring.repository.StudentRepo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router

@Configuration
class JacksonRouters(private val repo: StudentRepo) {

    @Bean
    fun routes() = router {
        "/students".nest {
            GET("") { _ -> ServerResponse.ok().body(repo.findAll()) }
        }
    }
}