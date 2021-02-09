package de.keycon.metricscollector

import de.keycon.metricscollector.github.GitHubProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(GitHubProperties::class)
class MetricsCollectorApplication

fun main(args: Array<String>) {
    runApplication<MetricsCollectorApplication>(*args)
}
