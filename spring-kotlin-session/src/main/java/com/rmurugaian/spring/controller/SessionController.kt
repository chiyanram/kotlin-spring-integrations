package com.rmurugaian.spring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.WebSession
import reactor.core.publisher.Mono

@RestController
class SessionController {

    @PostMapping("/session")
    fun put(session: WebSession): Mono<String> {
        session.attributes.computeIfAbsent("name") { "Ram" }
        return Mono.just("Value updated in session!")
    }


    @GetMapping("/session")
    fun get(session: WebSession): Mono<String> {
        return Mono.just(session.getAttribute<String>("name")!!)
    }

}