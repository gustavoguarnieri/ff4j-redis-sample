package com.example.ff4jredissample.config

import org.ff4j.FF4j
import org.ff4j.store.EventRepositoryRedis
import org.ff4j.store.FeatureStoreRedis
import org.ff4j.store.PropertyStoreRedis
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnClass(FF4j::class)
class FF4jConfig(
    private val redisConfig: RedisConfig,
) {

    @Bean
    fun getFF4j(): FF4j? {

        val ff4j = FF4j()

        ff4j.featureStore = FeatureStoreRedis(redisConfig.redisConnection())
        ff4j.propertiesStore = PropertyStoreRedis(redisConfig.redisConnection())
        ff4j.eventRepository = EventRepositoryRedis(redisConfig.redisConnection())

        ff4j.audit(true)
        ff4j.autoCreate(true)

        return ff4j
    }
}