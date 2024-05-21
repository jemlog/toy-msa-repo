package com.example.toyorderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyOrderServiceApplication

fun main(args: Array<String>) {
    runApplication<ToyOrderServiceApplication>(*args)
}
