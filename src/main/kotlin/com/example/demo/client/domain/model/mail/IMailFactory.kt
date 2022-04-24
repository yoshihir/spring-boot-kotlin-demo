package com.example.demo.client.domain.model.mail

import software.amazon.awssdk.services.sqs.SqsClient

interface IMailFactory {
    fun create(mail: MailTemplate, client: SqsClient): SQSMessage
}
