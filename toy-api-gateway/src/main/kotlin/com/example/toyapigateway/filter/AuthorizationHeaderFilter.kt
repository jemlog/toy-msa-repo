package com.example.toyapigateway.filter

import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec


@Component
class AuthorizationHeaderFilter : AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>(Config::class.java) {

    val log: Logger = LoggerFactory.getLogger(AuthorizationHeaderFilter::class.java)

    data class Config(
        val whiteList: Map<String, String>
    )

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter{ exchange, chain ->

            val request = exchange.request

            if(!request.headers.containsKey(HttpHeaders.AUTHORIZATION)){
                return@GatewayFilter onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
            }

            val authorizationHeader = request.headers[HttpHeaders.AUTHORIZATION]!![0]
            val jwt = authorizationHeader.replace("Bearer", "")

            if(!isJwtValid(jwt)){
                return@GatewayFilter onError(exchange, "The requested token is invalid.", HttpStatus.UNAUTHORIZED)
            }

            return@GatewayFilter chain.filter(
                exchange.mutate()
                    .request(
                        request.mutate()
                            .header("X-USER-ID", "1234")
                            .build()
                    )
                    .build()
            )
        }
    }

    private fun onError(exchange: ServerWebExchange, err: String, httpStatus: HttpStatus): Mono<Void> {
        val response = exchange.response
        response.setStatusCode(httpStatus)
        val bytes: ByteArray = err.toByteArray(StandardCharsets.UTF_8)
        val buffer: DataBuffer = exchange.response.bufferFactory().wrap(bytes)
        return response.writeWith(Flux.just(buffer))
    }

    private fun isJwtValid(jwt: String): Boolean {
        val secretKeyBytes: ByteArray = Base64.getEncoder().encode("fasfafsfdasfdsasdfasdfasdfewfcverwgvre".toByteArray())
        val signingKey: SecretKey = SecretKeySpec(secretKeyBytes, Jwts.SIG.HS512.id)
        var returnValue = true
        var subject: String? = null
        try {
            val jwtParser: JwtParser = Jwts.parser()
                .verifyWith(signingKey)
                .build()
            subject = jwtParser.parseEncryptedClaims(jwt).payload.subject
        } catch (ex: Exception) {
            returnValue = false
        }
        if (subject.isNullOrEmpty()) {
            returnValue = false
        }
        return returnValue
    }
}