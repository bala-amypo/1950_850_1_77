package com.example.demo.config;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jws;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {

    private final SecretKey secretKey;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.validityInMs = validityInMs;
    }

    public String generateToken(User user) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    public Jws<Claims> validateAndParse(String token) {

        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build();

        return parser.parseClaimsJws(token);
    }
}
