package de.keycon.metricscollector.github

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("github")
class GithubProperties {
    lateinit var credentials: String
    lateinit var api: String
    lateinit var urls: List<String>
}
