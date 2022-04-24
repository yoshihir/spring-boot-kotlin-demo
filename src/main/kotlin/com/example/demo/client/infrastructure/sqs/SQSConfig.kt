package com.example.demo.client.infrastructure.sqs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient
import java.net.URI

@Configuration
@Profile("local")
class SQSConfig {
    @Bean
    fun sqsClient(): SqsClient {
        val credentialsProvider = StaticCredentialsProvider.create(
            AwsBasicCredentials.create("dummy", "dummy")
        )

        return SqsClient.builder()
            .region(Region.AP_NORTHEAST_1)
            .credentialsProvider(credentialsProvider)
            .endpointOverride(URI("http://localhost:4566"))
            .build()
    }
}
