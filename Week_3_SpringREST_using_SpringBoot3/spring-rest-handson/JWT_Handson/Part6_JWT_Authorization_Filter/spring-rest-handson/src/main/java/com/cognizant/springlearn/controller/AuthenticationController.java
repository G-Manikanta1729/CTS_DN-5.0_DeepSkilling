package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET =
            "secretkeysecretkeysecretkeysecretkey";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("Start");

        String user = getUser(authHeader);

        LOGGER.info("Authenticated User : {}", user);

        String token = generateJwt(user);

        Map<String, String> response = new HashMap<>();

        response.put("token", token);

        LOGGER.info("End");

        return response;
    }

    private String getUser(String authHeader) {

        String encodedCredentials = authHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.info("Decoded Credentials : {}", credentials);

        return credentials.split(":")[0];
    }

    private String generateJwt(String user) {

        SecretKey key =
                Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(key)
                .compact();
    }
}