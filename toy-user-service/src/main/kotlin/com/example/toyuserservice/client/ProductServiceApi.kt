package com.example.toyuserservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("product-service")
internal interface ProductServiceApi {

   @GetMapping(
      value = ["/users/{userId}/products"],
      produces = [MediaType.APPLICATION_JSON_VALUE],
      consumes = [MediaType.APPLICATION_JSON_VALUE],
   )
   fun getProducts(@PathVariable userId: Long): List<ProductResponse>
}