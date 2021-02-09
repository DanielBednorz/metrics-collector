package de.keycon.metricscollector

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class MetricsCollectorApplication

fun main(args: Array<String>) {
    runApplication<MetricsCollectorApplication>(*args)
}
