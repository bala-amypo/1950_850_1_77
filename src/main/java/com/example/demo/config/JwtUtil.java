package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final int expiry;

    // ✅ REQUIRED BY TEST
    public JwtUtil(String secret, int expiry) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiry = expiry;
    }

    // optional default (keep if you want)
    public JwtUtil() {
        this("defaultsecretdefaultsecretdefaultsecret", 3600000);
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ REQUIRED BY TEST
    public String validateAndParse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
