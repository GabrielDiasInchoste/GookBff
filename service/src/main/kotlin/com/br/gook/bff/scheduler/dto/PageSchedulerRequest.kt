package com.br.gook.bff.scheduler.dto

import com.br.gook.data.SchedulerStatus

data class PageSchedulerRequest(
    val courtId: Long?,
    val customerEmail: String?,
    val status: SchedulerStatus?
)