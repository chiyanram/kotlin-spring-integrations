package com.rmurugaian.spring.config

import com.rmurugaian.spring.domain.Student
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * @author rmurugaian 2018-10-26
 */
@Configuration
@EnableRedisRepositories
class RedisConfig {

    @Bean
    fun redisConnectionFactory(): ReactiveRedisConnectionFactory {
        return LettuceConnectionFactory()
    }

    @Bean
    fun reactiveRedisOperations(factory: ReactiveRedisConnectionFactory): ReactiveRedisOperations<String, Student> {
        val serializer = Jackson2JsonRedisSerializer(Student::class.java)
        val builder = RedisSerializationContext.newSerializationContext<String, Student>(StringRedisSerializer())
        val context = builder.value(serializer).build()

        return ReactiveRedisTemplate(factory, context)
    }
}