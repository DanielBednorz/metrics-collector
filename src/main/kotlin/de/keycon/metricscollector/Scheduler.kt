package de.keycon.metricscollector

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class Scheduler{

    private val logger = mu.KotlinLogging.logger {}

    @Scheduled(fixedRate = 5000)
    fun logResult() {
        logger.info("The time is now ${DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now())}")
    }
}
