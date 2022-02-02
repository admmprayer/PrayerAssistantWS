package com.admmprayergroup.assistant.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DefaultController {

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> introduction() {
        Map<String, String> responseValue = new HashMap<>();
        responseValue.put("swaggerURL", "http://localhost:8080/swagger-ui.html");
        return ResponseEntity.ok(responseValue);
    }

}
