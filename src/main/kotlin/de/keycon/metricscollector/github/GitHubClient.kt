package de.keycon.metricscollector.github

import de.keycon.metricscollector.exception.NotFoundException
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI


@Component
class GitHubClient(
    val restTemplate: RestTemplate,
    val gitHubProperties: GitHubProperties
) {

    fun getRepoInfo(repositoryPath: String): GitHubRepo {

        val uri = UriComponentsBuilder.newInstance()
            .uri(URI(gitHubProperties.repos))
            .pathSegment(repositoryPath)
            .build().toUri()

        val requestEntity = HttpEntity(null, createAuthorizationHeader())

        val result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, GitHubRepo::class.java)
        return result.body ?: throw NotFoundException("No repositories found for '$repositoryPath'")
    }

    fun createAuthorizationHeader(): HttpHeaders {
        val httpHeaders = HttpHeaders()
        httpHeaders.set("Authorization", gitHubProperties.credentials)
        return httpHeaders
    }
}
