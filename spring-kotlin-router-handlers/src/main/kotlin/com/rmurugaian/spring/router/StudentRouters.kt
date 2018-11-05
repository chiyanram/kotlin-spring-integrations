package com.rmurugaian.spring.router

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.RouterFunctions.route

/**
 * @author rmurugaian 2018-10-30
 */
@Configuration
class StudentRouters @Autowired constructor(private val service: StudentService) {

    @Bean
    fun routes() = nest(
            path("/person"),
            route(GET("/{id}"), HandlerFunction { service.findByID(it) })
                    .andRoute(method(HttpMethod.GET), HandlerFunction { service.findAll(it) })
                    .andRoute(method(HttpMethod.POST), HandlerFunction { service.save(it) })
    )
}