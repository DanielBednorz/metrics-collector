package de.keycon.metricscollector.github

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("github")
class GitHubProperties {

    lateinit var credentials: String
    lateinit var repos: String
    lateinit var urls: List<String>
}
