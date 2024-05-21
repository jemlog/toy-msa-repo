package com.example.toyproductservice.presentation

import com.example.toyproductservice.application.dto.ProductResponse
import com.example.toyproductservice.application.`in`.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService
) {

    val log: Logger = LoggerFactory.getLogger(ProductController::class.java)

    @GetMapping("/users/{userId}/products")
    fun getProducts(@PathVariable(value = "userId") userId: Long): ResponseEntity<List<ProductResponse>>{
        log.info("product service income")
        val product = productService.getProduct(userId)
        log.info("getProducts() success")
        return ResponseEntity.ok(product)
    }
}