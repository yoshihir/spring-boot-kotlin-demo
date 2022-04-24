package com.example.demo.client.domain.model.mail

class SQSMessageId(val id: String?) {

    fun value(): String = id ?: run {
        throw IllegalArgumentException("SQSMessageId was not found!")
    }
}
