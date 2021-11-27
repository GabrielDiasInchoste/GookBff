package com.br.gook.bff.scheduler

import com.br.gook.bff.scheduler.client.SchedulerClient
import com.br.gook.bff.scheduler.dto.CancelRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerResponse
import com.br.gook.bff.scheduler.dto.SchedulerRequest
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class SchedulerServiceImpl(
    val schedulerClient: SchedulerClient,
) : SchedulerService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun findAllSchedulerWithPaginate(
        pageRequest: PageRequest,
        pageSchedulerRequest: PageSchedulerRequest
    ): PageSchedulerResponse {
        try {
            log.info("SchedulerUseCase.findAllSchedulerWithPaginate - Start - schedulerId : ")

            val response = schedulerClient.findAllSchedulerWithPaginate(
                pageRequest,
                pageSchedulerRequest
            )
            log.info("SchedulerUseCase.findAllSchedulerWithPaginate - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.findScheduler - Error to Find Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createScheduler(schedulerRequest: SchedulerRequest) {
        try {
            log.info("SchedulerUseCase.createScheduler - Start - schedulerRequest : $schedulerRequest")
            val response = schedulerClient.createScheduler(schedulerRequest)
            log.info("SchedulerUseCase.createScheduler - End -")
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.createScheduler - Error to Create Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun requestCancel(schedulerId: Long, cancelRequest: CancelRequest) {
        try {
            log.info("CancelUseCase.createCancel - Start - schedulerId : $schedulerId ,cancelRequest : $cancelRequest")
            schedulerClient.requestCancel(
                schedulerId,
                cancelRequest
            )
            log.info("CancelUseCase.createCancel - End -")
        } catch (ex: Exception) {
            log.error("CancelUseCase.createCancel - Error to Create Cancel - Error : ${ex.message}", ex)
            throw ex
        }
    }
}