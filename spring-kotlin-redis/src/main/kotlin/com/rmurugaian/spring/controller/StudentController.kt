package com.rmurugaian.spring.controller

import com.rmurugaian.spring.domain.Student
import com.rmurugaian.spring.service.StudentService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

/**
 * @author rmurugaian 2018-10-23
 */
@RestController
class StudentController constructor(private val service: StudentService) {

    @GetMapping("/students")
    fun all(): Flux<Student> {
        return service.findAll()
    }

    @PostMapping("/students")
    fun save(@RequestBody student: Student): Mono<Student> {

        return service.save(student)
    }

    @GetMapping("/students/{id}")
    fun findByID(@PathVariable id: String): Mono<Optional<Student>> {

        return service.findByID(id)
    }
}
