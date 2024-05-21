package com.example.toyuserservice.presentation

import com.example.toyuserservice.application.service.dto.UserResponse
import com.example.toyuserservice.application.service.`in`.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    val log: Logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/users/{userId}")
    fun getUsers(@PathVariable(value = "userId") userId: Long): ResponseEntity<UserResponse> {
        val userResponse = userService.getUser(userId)
        log.info("getUser() success")
        return ResponseEntity.ok(userResponse);
    }
}