package com.rmurugaian.spring.router

import com.rmurugaian.spring.model.Student
import com.rmurugaian.spring.repository.StudentRepo
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

/**
 * @author rmurugaian 2018-10-23
 */
@Service
class StudentService constructor(private val repo: StudentRepo) {

    fun findAll(request: ServerRequest): Mono<ServerResponse> = ok().body(repo.findAll())

    fun save(request: ServerRequest): Mono<ServerResponse> = request
            .bodyToMono(Student::class.java)
            .map { repo.save(it) }
            .flatMap { ok().body(it) }


    fun findByID(request: ServerRequest): Mono<ServerResponse> = ok().body(repo.findById(request.pathVariable("id")))
}