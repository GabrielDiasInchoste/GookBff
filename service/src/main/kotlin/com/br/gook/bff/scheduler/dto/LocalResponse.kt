package com.br.gook.bff.scheduler.dto

import java.time.LocalDateTime

data class LocalResponse(
    val id: Long,
    val name: String,
    val address: AddressResponse,
    val courts: List<CourtResponse>,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)