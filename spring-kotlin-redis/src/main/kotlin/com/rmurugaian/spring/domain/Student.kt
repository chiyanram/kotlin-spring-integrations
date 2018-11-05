package com.rmurugaian.spring.domain

import org.springframework.data.redis.core.RedisHash
import java.util.*

/**
 * @author rmurugaian 2018-10-26
 */
@RedisHash
data class Student(val id: String = UUID.randomUUID().toString(), val name: String, val age: Int)