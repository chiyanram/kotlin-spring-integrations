package com.rmurugaian.spring.repo

import com.rmurugaian.spring.domain.Student
import org.springframework.data.repository.CrudRepository

/**
 * @author rmurugaian 2018-10-26
 */
interface StudentRepo : CrudRepository<Student, String> {
}