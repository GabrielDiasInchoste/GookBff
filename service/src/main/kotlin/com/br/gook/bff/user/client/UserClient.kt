package com.br.gook.bff.user.client

import com.br.gook.bff.user.dto.UserRequest
import com.br.gook.bff.user.dto.UserResponse

interface UserClient {

    fun findUserByEmail(userEmail: String): UserResponse

    fun createUser(userRequest: UserRequest): UserResponse
}