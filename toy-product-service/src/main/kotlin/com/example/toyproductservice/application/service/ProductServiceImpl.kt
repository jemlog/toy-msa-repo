package com.example.toyproductservice.application.service

import com.example.toyproductservice.application.dto.ProductResponse
import com.example.toyproductservice.application.`in`.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : ProductService {

    override fun getProduct(userId: Long): List<ProductResponse> {
        return listOf(ProductResponse(1L, "product1"), ProductResponse(2L, "product2"))
    }
}