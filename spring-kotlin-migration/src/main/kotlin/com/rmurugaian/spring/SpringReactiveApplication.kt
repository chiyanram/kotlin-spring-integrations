package com.rmurugaian.spring

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
class SpringReactiveApplication {

    @Bean
    fun objectMapper(jackson2ObjectMapperBuilder: Jackson2ObjectMapperBuilder): ObjectMapper {
        return jackson2ObjectMapperBuilder.modules(Jdk8Module(),JavaTimeModule()).build()
    }
}

fun main(args: Array<String>) {
    runApplication<SpringReactiveApplication>(*args)
}
