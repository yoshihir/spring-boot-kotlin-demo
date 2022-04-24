package com.example.demo.client.domain.model.mail

import kotlinx.serialization.Serializable

@Serializable
class MailTemplate(val mailTemplateId: MailTemplateId, val mailTemplateVariables: MailTemplateVariables)
