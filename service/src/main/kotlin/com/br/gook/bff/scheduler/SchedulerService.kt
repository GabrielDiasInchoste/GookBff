package com.br.gook.bff.scheduler

import com.br.gook.bff.scheduler.dto.CancelRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerResponse
import com.br.gook.bff.scheduler.dto.SchedulerRequest

interface SchedulerService {

    fun findAllSchedulerWithPaginate(pageSchedulerRequest: PageSchedulerRequest): PageSchedulerResponse

    fun createScheduler(schedulerRequest: SchedulerRequest)

    fun requestCancel(schedulerId: Long, cancelRequest: CancelRequest)
}
