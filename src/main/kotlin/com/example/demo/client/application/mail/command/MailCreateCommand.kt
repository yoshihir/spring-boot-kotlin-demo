package com.example.demo.client.application.mail.command

data class MailCreateCommand(
    val mailTemplateId: String,
    val MailTemplateJsonVariables: String
)
