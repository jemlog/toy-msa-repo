package com.example.toyuserservice.application.service.`in`

import com.example.toyuserservice.application.service.dto.UserResponse

interface UserService {

    fun getUser(userId: Long): UserResponse
}