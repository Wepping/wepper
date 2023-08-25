package com.wepping.wepper.domain.user

import com.wepping.wepper.`interface`.user.dto.CreateUserDto
import com.wepping.wepper.`interface`.user.dto.UpdateUserDto
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

    override fun getUserById(id: Long): UserDto {
        return this.userPersistence.getById(id).toDto()
    }

    override fun getUserByUserId(userid: String): UserDto {
        return this.userPersistence.getByUserId(userid).toDto()
    }

    @Transactional
    override fun createUser(dto: CreateUserDto): UserDto {
        return this.userPersistence.create(dto).toDto()
    }

    @Transactional
    override fun updateUser(id: Long, dto: UpdateUserDto) : UserDto {
        var user = this.userPersistence.getById(id)
        dto.userName?.let { user.userName = it }
        dto.password?.let { user.password = it }
        dto.nickName?.let { user.nickName = it }
        dto.email?.let { user.email = it }
        return user.toDto()
    }

    @Transactional
    override fun removeUser(id: Long) {
        var user = this.userPersistence.getById(id)
        this.userPersistence.remove(user)
    }
}