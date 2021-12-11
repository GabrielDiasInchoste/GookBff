package com.br.gook.bff.scheduler

import com.br.gook.bff.scheduler.dto.*

interface SchedulerService {

    fun findAllSchedulerWithPaginate(pageSchedulerRequest: PageSchedulerRequest): PageSchedulerResponse

    fun createScheduler(schedulerRequest: SchedulerRequest): SchedulerResponse

    fun requestCancel(schedulerId: Long, cancelRequest: CancelRequest): SchedulerResponse

    fun findAllLocalWithPaginate(pageLocalRequest: PageLocalRequest): PageLocalResponse
}
