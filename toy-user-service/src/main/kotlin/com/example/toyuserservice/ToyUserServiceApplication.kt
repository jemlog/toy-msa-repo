package com.example.toyuserservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class ToyUserServiceApplication

fun main(args: Array<String>) {
    runApplication<ToyUserServiceApplication>(*args)
}
