package com.rmurugaian.spring.router

import com.rmurugaian.spring.model.Student
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpMethod.POST
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RequestPredicates.method
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body

/**
 * @author rmurugaian 2018-10-29
 */
@Configuration
class StudentRouter {

    @Bean
    fun routes(service: StudentService) = nest(
            path("/students").and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)),
            route(
                    method(POST),
                    HandlerFunction<ServerResponse> {
                        it
                                .bodyToMono(Student::class.java)
                                .map { service.save(it) }
                                .flatMap { ok().body(it) }
                    }
            ).andRoute(
                    method(GET), HandlerFunction { ok().body(service.findAll()) }
            ).andRoute(
                    path("/{id}"), HandlerFunction { ok().body(service.findByID(it.pathVariable("id"))) }
            )
    )
}