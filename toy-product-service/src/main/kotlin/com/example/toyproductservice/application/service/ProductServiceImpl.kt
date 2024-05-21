package com.example.toyproductservice.application.service

import com.example.toyproductservice.application.dto.ProductResponse
import com.example.toyproductservice.application.`in`.ProductService
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val kafkaTemplate: KafkaTemplate<String, Long>
) : ProductService {

    override fun getProduct(userId: Long): List<ProductResponse> {
        kafkaTemplate.send(ProducerRecord("test-topic","key", 2L));
        return listOf(ProductResponse(1L, "product1"), ProductResponse(2L, "product2"))
    }
}