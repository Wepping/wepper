package com.wepping.wepper.api.user

import com.wepping.wepper.`interface`.user.dto.CreateUserDto
import com.wepping.wepper.`interface`.user.dto.UpdateUserDto
import com.wepping.wepper.`interface`.user.dto.UserDto
import com.wepping.wepper.`interface`.user.dto.UserListDto
import com.wepping.wepper.`interface`.user.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/v1/users")
    fun getUsers(): UserListDto {
        return this.userService.getAllUsers()
    }

    @PostMapping("/v1/users")
    fun createUser(@RequestBody dto: CreateUserDto): UserDto {
        return this.userService.createUser(dto)
    }

    @GetMapping("/v1/users/{id}")
    fun getUserById(@PathVariable id: Long): UserDto {
        return this.userService.getUserById(id)
    }

    @PatchMapping("/v1/users/{id}")
    fun updateUserData(@PathVariable id: Long, @RequestBody dto: UpdateUserDto): UserDto {
        return this.userService.updateUser(id, dto)
    }

    @DeleteMapping("/v1/users/{id}")
    fun deleteUser(@PathVariable id: Long) {
        this.userService.removeUser(id)
    }
}