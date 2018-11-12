package com.rmurugaian.spring

import com.rmurugaian.spring.domain.Department
import com.rmurugaian.spring.domain.Student
import com.rmurugaian.spring.repository.StudentRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class SpringJacksonApplication(private val repo: StudentRepo) {

    @Bean
    fun runner() = CommandLineRunner {

        repo
                .saveAll(
                        Arrays.asList(
                                Student("name", Department("CSE")),
                                Student("name2", Department("ECE"))))
                .subscribe()

    }

}


fun main(args: Array<String>) {
    runApplication<SpringJacksonApplication>(*args)
}