package com.example.toyapigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@EnableDiscoveryClient
@SpringBootApplication
class ToyApiGatewayApplication

fun main(args: Array<String>) {
    runApplication<ToyApiGatewayApplication>(*args)
}
