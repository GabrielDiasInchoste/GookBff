package com.br.gook.bff.controller

import com.br.gook.bff.scheduler.SchedulerService
import com.br.gook.bff.scheduler.dto.*
import com.br.gook.data.SchedulerStatus
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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
        @RequestParam(value = "sort", defaultValue = "DESC") sort: String?,
        @RequestParam(value = "customerEmail") customerEmail: String?,
        @RequestParam(value = "courtId") courtId: Long?,
        @RequestParam(value = "status") status: SchedulerStatus?,

        ): ResponseEntity<PageSchedulerResponse> {

        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                schedulerService.findAllSchedulerWithPaginate(
                    PageRequest.of(
                        page,
                        linesPage,
                        if (sort == "ASC") Sort.by("id").ascending() else Sort.by("id").descending()
                    ),
                    PageSchedulerRequest(
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
    ): ResponseEntity<Any> {
        schedulerService.createScheduler(schedulerRequest)

        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .build()
    }

    @PostMapping(value = ["schedulerId/{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postCancel(
        @PathVariable(value = "schedulerId") schedulerId: Long,
        @RequestBody @Valid cancelRequest: CancelRequest
    ): ResponseEntity<SchedulerResponse> {
        schedulerService.requestCancel(schedulerId, cancelRequest)

        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .build()
    }

}