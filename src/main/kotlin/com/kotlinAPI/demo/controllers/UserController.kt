package com.kotlinAPI.demo.controllers

import com.kotlinAPI.demo.`interface`.IUserService
import com.kotlinAPI.demo.converters.UserCreateRequest
import com.kotlinAPI.demo.domain.User
import com.kotlinAPI.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import kotlin.jvm.Throws

@RestController("/users")
class UserController {

    @Autowired
    lateinit var userService: IUserService;

    @GetMapping("/users")
    fun listAll(): List<User>? {
        return userService.getAll();
    }

    @Throws(Exception::class)
    @PostMapping("/users")
    fun createUser(@RequestBody user: UserCreateRequest): User {
        return userService.create(user);
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable("id") id: String) {
        userService.delete(id);
    }
}