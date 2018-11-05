package com.rmurugaian.spring.controller

import com.rmurugaian.spring.model.Student
import com.rmurugaian.spring.service.StudentService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

/**
 * @author rmurugaian 2018-10-23
 */
@RestController
class StudentController constructor(private val service: StudentService) {

    @GetMapping("/students")
    fun all(): Flux<Student> = service.findAll()

    @PostMapping("/students")
    fun save(@RequestBody student: Student) = service.save(student)

    @GetMapping("/students/{id}")
    fun findByID(@PathVariable id: String) = service.findByID(id)
}
