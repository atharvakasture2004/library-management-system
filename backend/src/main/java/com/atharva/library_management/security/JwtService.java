package com.atharva.library_management.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey12";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String username) {
        Instant now = Instant.now();
        Instant expirationTime = now.plus(1, ChronoUnit.HOURS);

        return Jwts.builder()
                .subject(username)                                
                .issuedAt(Date.from(now))                        
                .expiration(Date.from(expirationTime))            
                .signWith(key)                                   
                .compact();
    }
}
