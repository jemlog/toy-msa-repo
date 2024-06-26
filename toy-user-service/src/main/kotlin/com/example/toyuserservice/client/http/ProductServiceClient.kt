package com.example.toyuserservice.client.http

import org.springframework.stereotype.Component

@Component
class ProductServiceClient internal constructor(
    private val productServiceApi: ProductServiceApi,
) {
    fun getProducts(userId: Long): List<ProductResponse>{
        return productServiceApi.getProducts(userId)
    }
}