package de.keycon.metricscollector.github

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock

@SpringBootTest
@AutoConfigureWireMock
class GitHubServiceIntTest {

    @Autowired
    lateinit var gitHubService: GitHubService

    @Test
    fun `verify metrics of metricts-collector`() {

        val result = gitHubService.getGitHubRepos()

        assertThat(result.size).isEqualTo(1)
        assertThat(result.first().name).isEqualTo("metrics-collector")
    }
}
