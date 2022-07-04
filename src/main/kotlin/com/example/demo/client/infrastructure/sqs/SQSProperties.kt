package com.example.demo.client.infrastructure.sqs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "aws.sqs.mail")
data class SQSProperties(
    val simpleQueueUrl: String,
)
