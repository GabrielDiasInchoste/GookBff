package com.br.gook.bff.scheduler

import com.br.gook.bff.scheduler.client.SchedulerClient
import com.br.gook.bff.scheduler.dto.CancelRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerResponse
import com.br.gook.bff.scheduler.dto.SchedulerRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SchedulerServiceImpl(
    val schedulerClient: SchedulerClient,
) : SchedulerService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun findAllSchedulerWithPaginate(
        pageSchedulerRequest: PageSchedulerRequest
    ): PageSchedulerResponse {
        try {
            log.info("SchedulerServiceImpl.findAllSchedulerWithPaginate - Start - pageSchedulerRequest :$pageSchedulerRequest ")

            val response = schedulerClient.findAllSchedulerWithPaginate(
                pageSchedulerRequest.page,
                pageSchedulerRequest.linesPage,
                pageSchedulerRequest.sort,
                pageSchedulerRequest.customerEmail,
                pageSchedulerRequest.courtId,
                pageSchedulerRequest.status
            )
            log.info("SchedulerServiceImpl.findAllSchedulerWithPaginate - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("SchedulerServiceImpl.findScheduler - Error to Find Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createScheduler(schedulerRequest: SchedulerRequest) {
        try {
            log.info("SchedulerServiceImpl.createScheduler - Start - schedulerRequest : $schedulerRequest")
            schedulerClient.createScheduler(schedulerRequest)
            log.info("SchedulerServiceImpl.createScheduler - End -")
        } catch (ex: Exception) {
            log.error("SchedulerServiceImpl.createScheduler - Error to Create Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun requestCancel(schedulerId: Long, cancelRequest: CancelRequest) {
        try {
            log.info("SchedulerServiceImpl.createCancel - Start - schedulerId : $schedulerId ,cancelRequest : $cancelRequest")
            schedulerClient.requestCancel(
                schedulerId,
                cancelRequest
            )
            log.info("SchedulerServiceImpl.createCancel - End -")
        } catch (ex: Exception) {
            log.error("SchedulerServiceImpl.createCancel - Error to Create Cancel - Error : ${ex.message}", ex)
            throw ex
        }
    }
}