package de.keycon.metricscollector.github

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class GitHubController(
    val gitHubService: GitHubService
) {

    @GetMapping(path = ["githubrepos"])
    fun getGitHubRepos(@RequestHeader headers: HttpHeaders) = ResponseEntity
        .status(HttpStatus.OK)
        .body(gitHubService.getGitHubRepos())

}
