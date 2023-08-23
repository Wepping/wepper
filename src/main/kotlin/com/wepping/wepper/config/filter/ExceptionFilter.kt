package com.wepping.wepper.config.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            // TODO: 2023/08/23 handle exception
        }
    }

    companion object {
        @Bean
        fun create(): ExceptionFilter = ExceptionFilter()
    }
}