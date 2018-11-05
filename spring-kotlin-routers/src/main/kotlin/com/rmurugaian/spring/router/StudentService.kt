package com.rmurugaian.spring.router

import com.rmurugaian.spring.model.Student
import com.rmurugaian.spring.repository.StudentRepo
import org.springframework.stereotype.Service

/**
 * @author rmurugaian 2018-10-23
 */
@Service
class StudentService constructor(private val repo: StudentRepo) {

    fun findAll() = repo.findAll()

    fun save(student: Student) = repo.save(student)

    fun findByID(id: String) = repo.findById(id)

}