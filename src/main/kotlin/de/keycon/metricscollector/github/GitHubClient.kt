package de.keycon.metricscollector.github

import de.keycon.metricscollector.exception.NotFoundException
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.URI


@Component
class GitHubClient(
    val restTemplate: RestTemplate,
    val githubProperties: GithubProperties
) {

    fun getRepoInfo(repositoryPath: String): GitHubRepo {

        val uri = URI("${githubProperties.api}/repos/$repositoryPath")

        val requestEntity = HttpEntity(null, null)

        val result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, GitHubRepo::class.java)
        return result.body ?: throw NotFoundException("No repositories found for '$repositoryPath'")
    }
}
