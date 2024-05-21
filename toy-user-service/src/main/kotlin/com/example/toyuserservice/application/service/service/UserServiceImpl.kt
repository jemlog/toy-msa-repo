package com.example.toyuserservice.application.service.service

import com.example.toyuserservice.application.service.dto.UserResponse
import com.example.toyuserservice.application.service.`in`.UserService
import com.example.toyuserservice.client.ProductServiceClient
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val productServiceClient: ProductServiceClient
) : UserService {

    override fun getUser(userId: Long): UserResponse{

        val products = productServiceClient.getProducts(userId)
        return UserResponse(userId, "jemin", products)
    }
}