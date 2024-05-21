package com.example.toyapigateway

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    val log: Logger = LoggerFactory.getLogger(HealthController::class.java)

    @GetMapping("/start")
    fun startUp(): String{
        log.info("startup prove...")
        return "up"
    }

    @GetMapping("/readiness")
    fun readiness(): String{
        log.info("readiness prove...")
        return "up"
    }

    @GetMapping("/liveness")
    fun liveness(): String{
        log.info("liveness prove...")
        return "up"
    }
}