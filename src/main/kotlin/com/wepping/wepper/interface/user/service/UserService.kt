package com.wepping.wepper.`interface`.user.service

import com.wepping.wepper.`interface`.user.dto.UserDto
import com.wepping.wepper.`interface`.user.dto.UserListDto

open abstract class UserService(
) {
    abstract fun getAllUsers(): UserListDto

    abstract fun getUserById(id: String): UserDto
}