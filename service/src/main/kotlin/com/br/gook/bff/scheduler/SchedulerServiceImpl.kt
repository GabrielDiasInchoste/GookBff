package com.br.gook.bff.scheduler

import com.br.gook.bff.scheduler.client.SchedulerClient
import com.br.gook.bff.scheduler.dto.*
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
            log.error(
                "SchedulerServiceImpl.findAllSchedulerWithPaginate - Error to Find Scheduler - Error : ${ex.message}",
                ex
            )
            throw ex
        }
    }

    override fun createScheduler(schedulerRequest: SchedulerRequest): SchedulerResponse {
        try {
            log.info("SchedulerServiceImpl.createScheduler - Start - schedulerRequest : $schedulerRequest")
            val response = schedulerClient.createScheduler(schedulerRequest)
            log.info("SchedulerServiceImpl.createScheduler - End - response $response")
            return response
        } catch (ex: Exception) {
            log.error("SchedulerServiceImpl.createScheduler - Error to Create Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun requestCancel(schedulerId: Long, cancelRequest: CancelRequest): SchedulerResponse {
        try {
            log.info("SchedulerServiceImpl.createCancel - Start - schedulerId : $schedulerId ,cancelRequest : $cancelRequest")
            val response = schedulerClient.requestCancel(
                schedulerId,
                cancelRequest
            )
            log.info("SchedulerServiceImpl.createCancel - End - response: $response")
            return response

        } catch (ex: Exception) {
            log.error("SchedulerServiceImpl.createCancel - Error to Create Cancel - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun findAllLocalWithPaginate(
        pageLocalRequest: PageLocalRequest
    ): PageLocalResponse {
        try {
            log.info("SchedulerServiceImpl.findAllLocalWithPaginate - Start - pageLocalRequest :$pageLocalRequest ")

            val response = schedulerClient.findAllLocalWithPaginate(
                pageLocalRequest.page,
                pageLocalRequest.linesPage,
                pageLocalRequest.sort,
                pageLocalRequest.courtId,
                pageLocalRequest.addressId
            )
            log.info("SchedulerServiceImpl.findAllLocalWithPaginate - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error(
                "SchedulerServiceImpl.findAllLocalWithPaginate - Error to Find Scheduler - Error : ${ex.message}",
                ex
            )
            throw ex
        }
    }
}