package com.br.gook.bff.user

import com.br.gook.bff.user.client.UserClient
import com.br.gook.bff.user.dto.UserRequest
import com.br.gook.bff.user.dto.UserResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userClient: UserClient
) : UserService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun findUserByEmail(userEmail: String): UserResponse {
        try {
            log.info("UserServiceImpl.findUserByEmail - Start - userEmail : $userEmail")
            val response = userClient.findUserByEmail(userEmail)
            log.info("UserUseCase.findUserByEmail - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CancelUseCase.findUser - Error to Find User - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createUser(userRequest: UserRequest): UserResponse {
        try {
            log.info("UserServiceImpl.createUser - Start - userRequest : $userRequest")
            val response = userClient.createUser(userRequest)
            log.info("UserUseCase.createUser - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CancelUseCase.createUser - Error to Create User - Error : ${ex.message}", ex)
            throw ex
        }
    }

}