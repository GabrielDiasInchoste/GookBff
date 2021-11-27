package com.br.gook.bff.user

import com.br.gook.bff.user.dto.UserRequest
import com.br.gook.bff.user.dto.UserResponse

interface UserService {
    fun findUserByEmail(userEmail: String): UserResponse

    fun createUser(userRequest: UserRequest): UserResponse
}