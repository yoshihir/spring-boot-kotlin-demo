package com.example.demo.client.domain.model.mail

class SQSMessageResult(val result: Boolean) {
    fun value(): Boolean = result
}
