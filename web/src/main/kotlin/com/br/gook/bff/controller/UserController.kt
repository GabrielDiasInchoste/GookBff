package com.br.gook.bff.controller

import com.br.gook.bff.user.UserService
import com.br.gook.bff.user.dto.UserRequest
import com.br.gook.bff.user.dto.UserResponse
import org.springframework.context.annotation.Role
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val userService: UserService
) {

    @GetMapping(value = ["/email/{userEmail}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(
        @PathVariable(value = "userEmail") userEmail: String
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(userService.findUserByEmail(userEmail))
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postUser(
        @RequestBody @Valid userRequest: UserRequest
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(userService.createUser(userRequest))
    }

}