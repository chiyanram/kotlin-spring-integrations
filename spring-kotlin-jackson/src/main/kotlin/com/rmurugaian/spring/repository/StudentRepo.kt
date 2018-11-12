package com.rmurugaian.spring.repository

import com.rmurugaian.spring.domain.Student
import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author rmurugaian 2018-10-22
 */
interface StudentRepo : ReactiveCrudRepository<Student, String>