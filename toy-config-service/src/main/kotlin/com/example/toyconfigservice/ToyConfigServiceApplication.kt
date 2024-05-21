package com.example.toyconfigservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyConfigServiceApplication

fun main(args: Array<String>) {
	runApplication<ToyConfigServiceApplication>(*args)
}
