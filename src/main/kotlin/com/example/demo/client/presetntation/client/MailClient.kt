package com.example.demo.client.presetntation.client

import com.example.demo.client.application.mail.MailApplicationService
import com.example.demo.client.application.mail.command.MailCreateCommand
import com.example.demo.client.presetntation.model.mail.MailTemplateRequestModel
import com.example.demo.client.presetntation.model.mail.MailTemplateResponseModel

class MailClient {
    fun mailTemplateSend(request: MailTemplateRequestModel): MailTemplateResponseModel {
        val command = MailCreateCommand(request.mailTemplateId, request.MailTemplateJsonVariables)
        val result = MailApplicationService().create(command)
        return MailTemplateResponseModel(result.sqsMessageId.value(), result.sqsMessageResult.value())
    }
}
