package com.br.gook.bff.controller

import com.br.gook.bff.scheduler.SchedulerService
import com.br.gook.bff.scheduler.dto.*
import com.br.gook.data.SchedulerStatus
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/scheduler")
class SchedulerController(
    private val schedulerService: SchedulerService
) {

    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllScheduler(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "10") linesPage: Int,
        @RequestParam(value = "sort", defaultValue = "DESC") sort: String,
        @RequestParam(value = "customerEmail", required = false) customerEmail: String?,
        @RequestParam(value = "courtId", required = false) courtId: Long?,
        @RequestParam(value = "status", required = false) status: SchedulerStatus?,

        ): ResponseEntity<PageSchedulerResponse> {

        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                schedulerService.findAllSchedulerWithPaginate(
                    PageSchedulerRequest(
                        page = page,
                        linesPage = linesPage,
                        sort = sort,
                        customerEmail = customerEmail,
                        courtId = courtId,
                        status = status
                    )
                )
            )
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postScheduler(
        @RequestBody @Valid schedulerRequest: SchedulerRequest
    ): ResponseEntity<SchedulerResponse> {

        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerService.createScheduler(schedulerRequest))

    }

    @PostMapping(value = ["cancel/schedulerId/{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postCancel(
        @PathVariable(value = "schedulerId") schedulerId: Long,
        @RequestBody @Valid cancelRequest: CancelRequest
    ): ResponseEntity<SchedulerResponse> {

        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerService.requestCancel(schedulerId, cancelRequest))
    }

}