package de.keycon.metricscollector.github

import org.springframework.stereotype.Service

@Service
class GithubService(
    val githubProperties: GithubProperties,
    val gitHubClient: GitHubClient
) {

    fun getRepos(): List<GitHubRepo> {
        return githubProperties.urls.map {
            gitHubClient.getRepoInfo(it)
        }
    }
}
