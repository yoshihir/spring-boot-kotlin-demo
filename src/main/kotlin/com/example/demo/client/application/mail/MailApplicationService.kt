package com.example.demo.client.application.mail

import com.example.demo.client.application.mail.command.MailCreateCommand
import com.example.demo.client.domain.model.mail.IMailFactory
import com.example.demo.client.domain.model.mail.MailTemplate
import com.example.demo.client.domain.model.mail.MailTemplateId
import com.example.demo.client.domain.model.mail.MailTemplateVariables
import com.example.demo.client.domain.model.mail.SQSMessage
import com.example.demo.client.infrastructure.sqs.SQSConfig
import com.example.demo.client.infrastructure.sqs.mail.MailFactory

internal class MailApplicationService {
    private val mailFactory: IMailFactory = MailFactory()

    fun create(command: MailCreateCommand): SQSMessage {
        return mailFactory.create(
            mail =
            MailTemplate(
                MailTemplateId(command.mailTemplateId),
                MailTemplateVariables(command.MailTemplateJsonVariables)
            ),
            client = SQSConfig().sqsClient()
        )
    }
}
