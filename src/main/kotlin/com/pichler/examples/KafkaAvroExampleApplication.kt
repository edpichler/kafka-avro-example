package com.pichler.examples

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableScheduling
class KafkaAvroExampleApplication

fun main(args: Array<String>) {
	runApplication<KafkaAvroExampleApplication>(*args)
}
