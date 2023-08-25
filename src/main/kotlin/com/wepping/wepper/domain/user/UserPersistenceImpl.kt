package com.wepping.wepper.domain.user

import com.wepping.wepper.`interface`.user.dto.CreateUserDto
import com.wepping.wepper.`interface`.user.persistence.UserPersistence
import com.wepping.wepper.common.exception.BadRequestException
import com.wepping.wepper.common.exception.NotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserId(userId: String): User?

    fun existsByUserId(userId: String): Boolean
}


@Component
class UserPersistenceImpl(
    private val userRepository: UserRepository,
) : UserPersistence() {

    override fun getAll(): List<User> {
        return this.userRepository.findAll().toList()
    }

    override fun getById(id: Long): User {
        return this.userRepository.findByIdOrNull(id) ?: throw NotFoundException("user id $id not exist.")
    }

    override fun getByUserId(userId: String): User {
        return this.userRepository.findByUserId(userId) ?: throw NotFoundException("user id $userId not exist.")
    }

    override fun create(dto: CreateUserDto): User {
        if (this.userRepository.existsByUserId(dto.userId)) {
            throw BadRequestException("userId ${dto.userId} already exist.")
        }
        val user = User(
            dto.userId,
            dto.password,
            dto.userName,
            dto.nickName,
            dto.email
        )
        return this.userRepository.save(user)
    }

    override fun remove(user: User) {
        this.userRepository.delete(user)
    }

}