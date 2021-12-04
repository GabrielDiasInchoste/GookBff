package com.br.gook.bff.user.client

import com.br.gook.bff.user.dto.UserRequest
import com.br.gook.bff.user.dto.UserResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "UserClient",
    url = "\${gook.user.host}"
)
interface UserClient {

    @GetMapping(
        path = ["\${gook.user.find.url}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findUserByEmail(
        @PathVariable(value = "userEmail") userEmail: String
    ): UserResponse

    @PostMapping(
        path = ["\${gook.user.create.url}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createUser(
        @RequestBody userRequest: UserRequest
    ): UserResponse
}