package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authorizationHeader) {

        LOGGER.info("Start");

        LOGGER.info("Authorization Header : {}", authorizationHeader);

        String encodedCredentials = authorizationHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.info("Decoded Credentials : {}", credentials);

        String username = credentials.split(":")[0];

        LOGGER.info("Username : {}", username);

        Map<String, String> response = new HashMap<>();

        response.put("token", "");

        LOGGER.info("End");

        return response;
    }
}