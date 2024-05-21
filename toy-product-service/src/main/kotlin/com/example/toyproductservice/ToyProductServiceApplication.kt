package com.example.toyproductservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyProductServiceApplication

fun main(args: Array<String>) {
    runApplication<ToyProductServiceApplication>(*args)
}
