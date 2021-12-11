package com.br.gook.bff.scheduler.dto

data class PageLocalRequest(
    val page: Int,
    val linesPage: Int,
    val sort: String,
    val addressId: Long?,
    val courtId: Long?
)