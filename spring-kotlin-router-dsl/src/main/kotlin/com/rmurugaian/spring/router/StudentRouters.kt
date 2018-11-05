package com.rmurugaian.spring.router

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

/**
 * @author rmurugaian 2018-10-30
 */
@Configuration
class StudentRouters @Autowired constructor(private val service: StudentService) {

    @Bean
    fun routes() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            "/students".nest {
                POST("", service::save)
                GET("/{id}", service::findByID)
                GET("", service::findAll)
            }
        }
    }
}