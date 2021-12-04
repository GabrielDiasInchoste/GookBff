package com.br.gook.bff.scheduler.client

import com.br.gook.bff.scheduler.dto.CancelRequest
import com.br.gook.bff.scheduler.dto.PageSchedulerResponse
import com.br.gook.bff.scheduler.dto.SchedulerRequest
import com.br.gook.data.SchedulerStatus
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FeignClient(
    name = "SchedulerClient",
    url = "\${gook.scheduler.host}"
)
interface SchedulerClient {

    @GetMapping(
        path = ["\${gook.scheduler.find.url}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllSchedulerWithPaginate(
        @RequestParam(value = "page") page: Int?,
        @RequestParam(value = "linesPerPage") linesPage: Int?,
        @RequestParam(value = "sort") sort: String?,
        @RequestParam(value = "customerEmail") customerEmail: String?,
        @RequestParam(value = "courtId") courtId: Long?,
        @RequestParam(value = "status") status: SchedulerStatus?,
    ): PageSchedulerResponse

    @PostMapping(
        path = ["\${gook.scheduler.create.url}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createScheduler(
        @RequestBody schedulerRequest: SchedulerRequest
    )

    @PostMapping(
        path = ["\${gook.scheduler.request.cancel.url}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun requestCancel(
        @PathVariable(value = "schedulerId") schedulerId: Long,
        @RequestBody cancelRequest: CancelRequest
    )
}