package com.example.toyuserservice.application.service.dto

import com.example.toyuserservice.client.ProductResponse

data class UserResponse(val userId: Long, val username: String, val orderedProducts: List<ProductResponse>)
