package com.example.toyservicediscovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class ToyServiceDiscoveryApplication

fun main(args: Array<String>) {
	runApplication<ToyServiceDiscoveryApplication>(*args)
}
