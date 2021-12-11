package com.br.gook.bff.scheduler.dto

import com.br.gook.data.SchedulerStatus
import java.time.LocalDateTime

data class SchedulerResponse(
    val id: Long,
    val customerEmail: String,
    val tokenSendPush: String?,
    val status: SchedulerStatus,
    val court: CourtResponse,
    val cancel: CancelResponse?,
    val schedule: LocalDateTime?,
    val confirmDate: LocalDateTime?,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)