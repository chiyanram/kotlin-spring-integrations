package com.rmurugaian.spring.model

import java.time.LocalDate
import java.util.*

/**
 * @author rmurugaian 2018-10-22
 */
data class Student(
        val id: String = UUID.randomUUID().toString(),
        val name: String,
        val dob: LocalDate)