package com.br.gook.bff.user.dto

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val pix: String,
    val permissions: List<UserPermission>,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)