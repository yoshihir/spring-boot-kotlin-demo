package com.example.demo.client.presetntation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @GetMapping("/")
    fun blog(): String {
        return ""
    }
}
