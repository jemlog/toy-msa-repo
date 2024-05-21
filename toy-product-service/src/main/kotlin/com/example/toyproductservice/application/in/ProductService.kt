package com.example.toyproductservice.application.`in`

import com.example.toyproductservice.application.dto.ProductResponse

interface ProductService {

    fun getProduct(userId: Long): List<ProductResponse>
}