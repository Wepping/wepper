package com.wepping.wepper.api.user

import com.wepping.wepper.`interface`.user.dto.UserDto
import com.wepping.wepper.`interface`.user.dto.UserListDto
import com.wepping.wepper.`interface`.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/v1/users")
    fun getUsers(): UserListDto {
        return this.userService.getAllUsers()
    }

    @GetMapping("/v1/users/{id}")
    fun getUserById(@PathVariable id: String): UserDto {
        return this.userService.getUserById(id)
    }
}