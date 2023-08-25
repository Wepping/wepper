package com.wepping.wepper.`interface`.user.service

import com.wepping.wepper.`interface`.user.dto.CreateUserDto
import com.wepping.wepper.`interface`.user.dto.UpdateUserDto
import com.wepping.wepper.`interface`.user.dto.UserDto
import com.wepping.wepper.`interface`.user.dto.UserListDto

open abstract class UserService(
) {
    abstract fun getAllUsers(): UserListDto

    abstract fun getUserById(id: Long): UserDto

    abstract fun getUserByUserId(userid: String): UserDto

    abstract fun createUser(dto: CreateUserDto) : UserDto

    abstract fun updateUser(id: Long, dto: UpdateUserDto) : UserDto

    abstract fun removeUser(id: Long)
}