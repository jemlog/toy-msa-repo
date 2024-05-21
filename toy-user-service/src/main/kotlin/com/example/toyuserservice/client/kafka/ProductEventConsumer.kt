package com.example.toyuserservice.client.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class ProductEventConsumer {

    val log: Logger = LoggerFactory.getLogger(ProductEventConsumer::class.java)

    @KafkaListener(topics = ["test-topic"])
    fun test(@Payload num: Long){
        log.info("get topic message {}", num)
    }
}