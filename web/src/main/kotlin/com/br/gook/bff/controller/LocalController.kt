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
@RequestMapping("/v1/local")
class LocalController(
    private val schedulerService: SchedulerService
) {
    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllLocal(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "10") linesPage: Int,
        @RequestParam(value = "sort", defaultValue = "DESC") sort: String,
        @RequestParam(value = "addressId") addressId: Long?,
        @RequestParam(value = "courtId") courtId: Long?
    ): ResponseEntity<PageLocalResponse> {

        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                schedulerService.findAllLocalWithPaginate(
                    PageLocalRequest(
                        page = page,
                        linesPage = linesPage,
                        sort = sort,
                        addressId = addressId,
                        courtId = courtId,
                    )
                )
            )
    }
}