package com.kotlinAPI.demo.service

import com.kotlinAPI.demo.`interface`.IUserService
import com.kotlinAPI.demo.converters.UserCreateRequest
import com.kotlinAPI.demo.domain.User
import com.kotlinAPI.demo.exceptions.CustomException
import com.kotlinAPI.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*
import kotlin.jvm.Throws

@Service
class UserService: IUserService {

    @Autowired
    lateinit var userRepository: UserRepository;

    override fun getAll(): List<User> {
        return userRepository.findAll();
    }

    @Throws(Exception::class)
    override fun create(user: UserCreateRequest): User {
        val u: User = this.convert(user);
        val userExists: User? = userRepository.findFirstByName(u.name);
        if(userExists != null) {
            throw CustomException("This name already exists!", "You can't create a user with the same name", "Try another name!");
        }
        return userRepository.save(u);
    }

    override fun delete(id: String) {
        val user: Optional<User> = userRepository.findById(id);

        if(!user.isPresent) {
            throw CustomException("You cant delete this user!", "You cant delete a user who doenst exists", "Try a valid user!");
        }

        userRepository.deleteById(id);
    }

    override fun convert(user: UserCreateRequest): User {
        return User(id = UUID.randomUUID().toString(), user.name);
    }
}