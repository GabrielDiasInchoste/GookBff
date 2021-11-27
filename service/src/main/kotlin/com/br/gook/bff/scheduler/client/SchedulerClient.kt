package com.br.gook.bff.scheduler.client

import com.br.gook.bff.scheduler.dto.CancelRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerResponse
import com.br.gook.bff.scheduler.dto.SchedulerRequest
import org.springframework.data.domain.PageRequest

interface SchedulerClient {

    fun findAllSchedulerWithPaginate(
        pageRequest: PageRequest,
        pageSchedulerRequest: PageSchedulerRequest
    ): PageSchedulerResponse

    fun createScheduler(schedulerRequest: SchedulerRequest)

    fun requestCancel(schedulerId: Long, cancelRequest: CancelRequest)
}