package de.keycon.metricscollector.github

import org.springframework.stereotype.Service

@Service
class GitHubService(
    val gitHubProperties: GitHubProperties,
    val gitHubClient: GitHubClient
) {

    fun getGitHubRepos(): List<GitHubRepo> {
        return gitHubProperties.urls.map {
            gitHubClient.getRepoInfo(it)
        }
    }
}
