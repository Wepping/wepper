package com.wepping.wepper.domain.user

import com.wepping.wepper.`interface`.user.dto.UserDto
import com.wepping.wepper.`interface`.user.dto.UserListDto
import com.wepping.wepper.`interface`.user.persistence.UserPersistence
import com.wepping.wepper.`interface`.user.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserServiceImpl(
    private val userPersistence: UserPersistence,
) : UserService(
) {

    override fun getAllUsers(): UserListDto {
        return UserListDto.create(this.userPersistence.getAll())
    }

    override fun getUserById(id: String): UserDto {
        return this.userPersistence.getById(id).toDto()
    }
}