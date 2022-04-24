package com.example.demo.client.infrastructure.sqs.mail

import com.example.demo.client.domain.model.mail.IMailFactory
import com.example.demo.client.domain.model.mail.MailTemplate
import com.example.demo.client.domain.model.mail.SQSMessage
import com.example.demo.client.domain.model.mail.SQSMessageId
import com.example.demo.client.domain.model.mail.SQSMessageResult
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.SendMessageRequest

internal class MailFactory : IMailFactory {
    override fun create(mail: MailTemplate, client: SqsClient): SQSMessage {
        val response = client.sendMessage(
            SendMessageRequest.builder()
                .queueUrl("http://localhost:4566/000000000000/mail-simple")
                .messageBody(Json.encodeToString(mail)).build()
        )

        return SQSMessage(SQSMessageId(response.messageId()), SQSMessageResult(true))
    }
}
