package com.wepping.wepper.domain.plan

import com.wepping.wepper.domain.user.User
import jakarta.persistence.*

@Entity
class Plan(
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    var user: User? = null
){
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null
}