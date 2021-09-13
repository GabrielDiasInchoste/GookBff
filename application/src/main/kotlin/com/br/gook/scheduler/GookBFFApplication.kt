package com.br.gook.scheduler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GookBFFApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<GookBFFApplication>(*args)
        }
    }
}
