package com.kotlinAPI.demo.`interface`

import com.kotlinAPI.demo.converters.UserCreateRequest
import com.kotlinAPI.demo.domain.User

interface IUserService {
    fun getAll(): List<User>;
    fun create(user: UserCreateRequest): User;
    fun delete(id: String);
    fun convert(user: UserCreateRequest): User;
}