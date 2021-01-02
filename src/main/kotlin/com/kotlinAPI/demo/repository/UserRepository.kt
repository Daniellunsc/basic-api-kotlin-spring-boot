package com.kotlinAPI.demo.repository

import com.kotlinAPI.demo.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
    fun findFirstByName(name: String): User;
}