package com.br.gook.bff.scheduler.dto

import com.br.gook.data.SchedulerStatus

data class PageSchedulerRequest(
    val page: Int,
    val linesPage: Int,
    val sort: String,
    val customerEmail: String?,
    val courtId: Long?,
    val status: SchedulerStatus?
)