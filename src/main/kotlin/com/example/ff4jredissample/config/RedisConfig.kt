package com.example.ff4jredissample.config

import org.ff4j.redis.RedisConnection
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RedisConfig(
    @Value("\${redis.host}")
    private val host: String,
    @Value("\${redis.port}")
    private val port: Int,
) {

    @Bean
    fun redisConnection(): RedisConnection {
        return RedisConnection(host, port)
    }
}