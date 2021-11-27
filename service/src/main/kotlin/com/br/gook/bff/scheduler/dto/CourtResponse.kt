package com.br.gook.bff.scheduler.dto

import java.time.LocalDateTime

data class CourtResponse(
    val id: Long,
    val name: String,
    val type: CourtType,
    val localId: Long,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)