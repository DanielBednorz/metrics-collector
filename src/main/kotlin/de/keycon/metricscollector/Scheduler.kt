package de.keycon.metricscollector

import de.keycon.metricscollector.github.GithubService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler(
    val githubService: GithubService
) {

    private val logger = mu.KotlinLogging.logger {}

    @Scheduled(fixedRate = 5000)
    fun logResult() {
        logger.info("Found repos: {}", githubService.getRepos().map { it.name })
    }
}
