package com.pichler.examples.avro

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Consumer {

    @Scheduled(fixedRate = 1000)
    fun todo()  {
        println("oi")
    }
}