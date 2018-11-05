package com.rmurugaian.spring.service

import com.rmurugaian.spring.domain.Student
import com.rmurugaian.spring.repo.StudentRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

/**
 * @author rmurugaian 2018-10-23
 */
@Service
class StudentService constructor(private val repo: StudentRepo) {

    fun findAll(): Flux<Student> {
        return Flux.fromIterable(repo.findAll())
    }

    fun save(student: Student): Mono<Student> {
        return Mono.fromSupplier { repo.save(student) }
    }

    fun findByID(id: String): Mono<Optional<Student>> {
        return Mono.fromSupplier { repo.findById(id) }
    }

}